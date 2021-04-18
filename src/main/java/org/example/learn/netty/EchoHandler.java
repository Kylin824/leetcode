package org.example.learn.netty;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.logging.Logger;


// 负责socket的数据输入、业务处理、结果输出
public class EchoHandler implements Runnable{
    private static Logger log = Logger.getLogger("EchoHandler");
    final SocketChannel socketChannel;
    final SelectionKey sk;
    final ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
    static final int RECEIVEING = 0, SENDING = 1;
    int state = RECEIVEING;

    EchoHandler(Selector selector, SocketChannel sc) throws IOException {
        socketChannel = sc;
        sc.configureBlocking(false);
        // 仅仅取得选择键，稍后设置感兴趣的IO事件
        sk = socketChannel.register(selector, 0);

        sk.attach(this);
        sk.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);
        selector.wakeup();
    }

    @Override
    public void run() {
        try {
            if (state == SENDING) {
                // 写入通道
                socketChannel.write(byteBuffer);
                byteBuffer.clear();
                // 写完后注册read就绪事件
                sk.interestOps(SelectionKey.OP_READ);
                state = RECEIVEING;
            } else if (state == RECEIVEING) {
                int length = 0;
                while ((length = socketChannel.read(byteBuffer)) > 0) {
                    log.info(new String(byteBuffer.array(), 0, length));
                }
                // byteBuffer切换成读模式
                byteBuffer.flip();
                sk.interestOps(SelectionKey.OP_WRITE);
                state = SENDING;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
