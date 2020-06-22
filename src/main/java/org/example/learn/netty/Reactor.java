//package org.example.learn.netty;
//
//import java.io.IOException;
//import java.nio.channels.SelectionKey;
//import java.nio.channels.Selector;
//import java.nio.channels.ServerSocketChannel;
//import java.nio.channels.SocketChannel;
//import java.util.Iterator;
//import java.util.Set;
//
//class Reactor implements Runnable{
//
//    Selector selector;
//    ServerSocketChannel serverSocket;
//
//    EchoServerReactor() throws IOException {
//
//
//        SelectionKey sk = serverSocket.register(selector, SelectionKey.OP_ACCEPT);
//        sk.attach(new AcceptorHandler());
//    }
//
//    public void run() {
//        try {
//            while (!Thread.interrupted()) {
//                selector.select();
//                Set selected = selector.selectedKeys();
//                Iterator it = selected.iterator();
//                while (it.hasNext()) {
//                    SelectionKey sk = it.next();
//                    dispatch(sk);
//                }
//                selected.clear();
//            }
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//    }
//
//        void dispatch(SelectionKey sk) {
//        Runnable handler = (Runnable) (sk.attachment());
//        if (handler != null) {
//            handler.run();
//        }
//    }
//
//
//    class AcceptorHandler implements Runnable {
//
//        @Override
//        public void run() {
//
//        }
//    }
//
//    class IOHandler implements Runnable {
//        final SocketChannel channel;
//        final SelectionKey sk;
//
//        IOHandler(Selector selector, SocketChannel c) throws IOException {
//            channel = c;
//            c.configureBlocking(false);
//            sk = channel.register(selector, 0);
//            sk.attach(this);
//            sk.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);
//        }
//
//        @Override
//        public void run() {
//
//        }
//    }
//}
