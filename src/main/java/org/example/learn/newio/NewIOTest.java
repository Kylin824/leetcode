package org.example.learn.newio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.IntBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NewIOTest {
    public static void main(String[] args) throws IOException {

        Selector selector = Selector.open();

        // 新建socket监听通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 设为非阻塞式
        serverSocketChannel.configureBlocking(false);
        // 绑定8899端口
        serverSocketChannel.bind(new InetSocketAddress(8899));
        // 向选择器注册ACCEP状态
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (selector.select() > 0) {
            Set selectedKeys = selector.selectedKeys();
            Iterator<SelectionKey> iter = selectedKeys.iterator();

            while (iter.hasNext()) {
                SelectionKey key = iter.next();
                if (key.isAcceptable()) {
                    // 通道监听到连接
                    System.out.println("New connection request!!!");


                }
                else if (key.isConnectable()) {
                    // 通道连接成功
                }
                else if (key.isReadable()) {
                    // 通道可读
                }
                else if (key.isWritable()) {
                    // 通道可写
                }
                // 处理完成，移除该选择键
                iter.remove();
            }
        }

    }
}
