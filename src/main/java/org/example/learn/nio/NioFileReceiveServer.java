package org.example.learn.nio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Logger;

public class NioFileReceiveServer {
    public static Logger log = Logger.getLogger("NioFileReceiveServer");
    private Charset charset = Charset.forName("UTF-8");
    private ByteBuffer byteBuffer = ByteBuffer.allocate(8196);
    Map<SelectableChannel, Client> clientMap = new HashMap<>();

    public void startServer() throws Exception {
        // 获取选择器
        Selector selector = Selector.open();
        // 获取通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        ServerSocket serverSocket = serverSocketChannel.socket();
        // 设置为非阻塞
        serverSocketChannel.configureBlocking(false);
        // 绑定连接
        InetSocketAddress address = new InetSocketAddress(9999);
        serverSocket.bind(address);
        // 注册通道
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        log.info("serverSocketChannel is listening...");
        // 轮询IO事件
        while (selector.select() > 0) {
            // 获取选择键集合
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                // 获取选择键并处理
                SelectionKey sk = iterator.next();
                if (sk.isAcceptable()) {
                    // 如果是IO就绪事件，则获取客户端连接
                    ServerSocketChannel server = (ServerSocketChannel) sk.channel();
                    SocketChannel socketChannel = server.accept();
                    if (socketChannel == null) continue;
                    // 非阻塞模式
                    socketChannel.configureBlocking(false);
                    // 通道注册
                    SelectionKey selectionKey = socketChannel.register(selector, SelectionKey.OP_READ);
                    Client client = new Client();
                    client.remoteAddress = (InetSocketAddress) socketChannel.getRemoteAddress();
                    clientMap.put(socketChannel, client);
                    log.info(socketChannel.getRemoteAddress() + "连接成功");
                } else if (sk.isReadable()) {
                    processData(sk);
                }
            }
        }
    }

    /**
     * 处理客户端传过来的数据
     * @param selectionKey
     * @throws Exception
     */
    private void processData(SelectionKey selectionKey) {
        Client client = clientMap.get(selectionKey.channel());
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        int length = 0;
        try {
            byteBuffer.clear();
            while ((length = socketChannel.read(byteBuffer)) > 0) {
                byteBuffer.flip();
                if (null == client.fileName) {
                    // 文件名
                    String fileName = charset.decode(byteBuffer).toString();
                    String destPath = "E:\\server";
                    File directory = new File(destPath);
                    if (!directory.exists()) {
                        directory.mkdir();
                    }
                    client.fileName = fileName;
                    String fullName = directory.getAbsolutePath() + File.separatorChar + fileName;
                    log.info("NIO 传输目标文件: " + fullName);
                    File file = new File(fullName);
                    FileChannel fileChannel = new FileOutputStream(file).getChannel();
                    client.outChannel = fileChannel;
                } else if (0 == client.fileLength) {
                    // 文件长度
                    long fileLength = byteBuffer.getLong();
                    client.fileLength = fileLength;
                    client.startTime = System.currentTimeMillis();
                    log.info("传输文件长度: " + fileLength);
                } else {
                    log.info("传输文件内容...");
                    client.outChannel.write(byteBuffer);
                }
                byteBuffer.clear();
            }
            selectionKey.cancel();
        } catch (IOException e) {
            selectionKey.cancel();
            e.printStackTrace();
            return;
        }
        // 读取数量为-1代表客户端传输结束标志
        if (length == -1) {
            log.info("传输完毕");
            selectionKey.cancel();
            long endTime = System.currentTimeMillis();
            log.info("传输毫秒数: " + (endTime - client.startTime));
        }
    }

    static class Client {
        String fileName;
        long fileLength;
        long startTime;
        InetSocketAddress remoteAddress;
        FileChannel outChannel;
    }

    public static void main(String[] args) throws Exception {
        NioFileReceiveServer nioFileReceiveServer = new NioFileReceiveServer();
        nioFileReceiveServer.startServer();
    }
}
