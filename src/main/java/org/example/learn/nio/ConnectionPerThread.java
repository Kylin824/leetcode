package org.example.learn.nio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ConnectionPerThread implements Runnable{

    private static final Integer SOCKET_SERVER_PORT = 8080;
    private static final Integer SERVER_BUFFER_SIZE = 1024;

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(SOCKET_SERVER_PORT);
            while (!Thread.interrupted()) {
                Socket socket = serverSocket.accept();

            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class Handler implements Runnable {

        final Socket socket;

        Handler(Socket s) {
            socket = s;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    byte[]  input = new byte[SERVER_BUFFER_SIZE];
                    socket.getInputStream().read(input);
                    byte[] output = null;
                    socket.getOutputStream().write(output);
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
