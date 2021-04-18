package org.example.learn.netty;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

class Reactor implements Runnable{

    final Selector selector;
    final ServerSocketChannel serverSocket;

    Reactor(int port) throws IOException {
        selector = Selector.open();
        serverSocket = ServerSocketChannel.open();
        serverSocket.socket().bind(new InetSocketAddress(port));
        serverSocket.configureBlocking(false);
        SelectionKey sk = serverSocket.register(selector, SelectionKey.OP_ACCEPT);
        sk.attach(new Acceptor());
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                selector.select();
                Set selected = selector.selectedKeys();
                Iterator it = selected.iterator();
                while (it.hasNext()) {
                    SelectionKey sk = (SelectionKey)it.next();
                    dispatch(sk);
                }
                selected.clear();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

        void dispatch(SelectionKey sk) {
        Runnable r = (Runnable) (sk.attachment());
        if (r != null) {
            r.run();
        }
    }


    class Acceptor implements Runnable {

        @Override
        public void run() {
            try {
                SocketChannel sc = serverSocket.accept();
                if (sc != null) {
                    new Handler(selector, sc);
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    class Handler implements Runnable {
        final SocketChannel sc;
        final SelectionKey sk;

        Handler(Selector selector, SocketChannel c) throws IOException {
            sc = c;
            c.configureBlocking(false);
            sk = sc.register(selector, 0);
            sk.attach(this);
            sk.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);
            selector.wakeup();
        }

        @Override
        public void run() {

        }
    }
}
