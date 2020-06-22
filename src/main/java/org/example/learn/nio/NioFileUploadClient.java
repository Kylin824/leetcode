package org.example.learn.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.logging.Logger;

/**
 * Send file to server
 */
public class NioFileUploadClient {

    private static Charset charset = Charset.forName("UTF-8");
    public static Logger log = Logger.getLogger("NioDiscardClientLog");


    public void sendFile() {
        try {
            String filePath = "E:\\client\\test.csv";
            String fileName = "test.csv";
            File file = new File(filePath);
            if (! file.exists()) {
                log.info("file not exist!");
                return;
            }
            FileChannel fileChannel = new FileInputStream(file).getChannel();
            SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("localhost", 9999));
            socketChannel.configureBlocking(false);
            while (!socketChannel.finishConnect()) {
            }
            log.info("client connect to server successfully!");
            // 发送文件名称
            ByteBuffer fileNameByteBuffer = charset.encode(fileName);
            socketChannel.write(fileNameByteBuffer);
            // 发送文件长度
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            buffer.putLong(file.length());
            buffer.flip();
            socketChannel.write(buffer);
            buffer.clear();
            // 发送文件内容
            log.info("begin to send file content");
            int length = 0;
            long progress = 0;
            while ((length = fileChannel.read(buffer)) > 0) {
                buffer.flip();
                socketChannel.write(buffer);
                buffer.clear();
                progress += length;
                log.info("| " + (100 * progress / file.length()) + "% |" );
                // Thread.sleep(1000);
            }
            if (length == -1) {
                socketChannel.shutdownOutput();
                socketChannel.close();
                log.info("finish sending");
            }
            log.info("file send success!");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        NioFileUploadClient client = new NioFileUploadClient();
        client.sendFile();
    }

}
