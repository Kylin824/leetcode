package org.example.learn.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.logging.Logger;

public class NioDiscardClient {
    public static Logger log = Logger.getLogger("NioDiscardClientLog");

    public static void  startClient() throws IOException {

        InetSocketAddress address = new InetSocketAddress("localhost", 9999);

        // 获取通道
        SocketChannel socketChannel = SocketChannel.open(address);
        // 非阻塞模式
        socketChannel.configureBlocking(false);
        // 不断自旋等待连接完成
        while (!socketChannel.finishConnect()) {
        }
        log.info("Client connected!");

        // 分配缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        // 写入数据
        byteBuffer.put("hello world".getBytes());
        //
        byteBuffer.flip();
        // 发送到服务器
        socketChannel.write(byteBuffer);
        socketChannel.shutdownOutput();
        socketChannel.close();
    }

    public static void main(String[] args) throws IOException {
        startClient();
    }

}
