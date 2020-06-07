package org.example.learn.current;

import java.util.concurrent.locks.LockSupport;

public class twoThread {

    static Thread t1 = null, t2 = null;

    public static void main(String[] args) {
        final char[] aI = "1234567".toCharArray();
        final char[] aC = "ABCDEFG".toCharArray();

        t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (char c : aI) {
                    System.out.print(c);
                    LockSupport.unpark(t2); // 释放t2
                    LockSupport.park(); // 阻塞自己
                }
            }
        }, "t1");

        t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (char c : aC) {
                    LockSupport.park(); // 阻塞自己
                    System.out.print(c);
                    LockSupport.unpark(t1); // 释放t1
                }
            }
        }, "t2");

        t1.start();
        t2.start();

    }
}
