package org.example.learn.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.logging.Logger;

public class NioDiscardServer {
    public static Logger log = Logger.getLogger("NioDiscardServerLog");

    public static void startServer() throws IOException {
        // 获取选择器
        Selector selector = Selector.open();
        // 获取通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 设置通道非阻塞
        serverSocketChannel.configureBlocking(false);
        // 绑定连接
        serverSocketChannel.bind(new InetSocketAddress(9999));
        log.info("start server!");

        // 注册通道事件
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        // 轮询IO事件
        while (selector.select() > 0) {
            // 获取选择键集合
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                // 获取选择键并处理
                SelectionKey sk = iterator.next();
                // 判断具体事件
                if (sk.isAcceptable()) {
                    // 如果是IO就绪事件，则获取客户端连接
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    // 非阻塞模式
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ);
                } else if (sk.isReadable()) {
                    // 如果是可读事件，则读取客户端数据
                    SocketChannel socketChannel = (SocketChannel) sk.channel();
                    // 读取数据，然后丢弃
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    int length = 0;
                    while ((length = socketChannel.read(byteBuffer)) > 0) {
                        byteBuffer.flip();
                        log.info(new String(byteBuffer.array(), 0, length));
                        byteBuffer.clear();
                    }
                    socketChannel.close();
                }
                iterator.remove();
            }
        }
        // 关闭监听
        serverSocketChannel.close();
    }

    public static void main(String[] args) throws IOException {
        startServer();
    }
}
