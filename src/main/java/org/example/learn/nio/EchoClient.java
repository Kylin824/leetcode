package org.example.learn.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class EchoClient {
    public void start() throws IOException {
        InetSocketAddress address = new InetSocketAddress("127.0.0.1", 9999);
        SocketChannel socketChannel = SocketChannel.open(address);
        socketChannel.configureBlocking(false);
        while (!socketChannel.finishConnect()) {
        }
        System.out.println("client start success");
    }
}
