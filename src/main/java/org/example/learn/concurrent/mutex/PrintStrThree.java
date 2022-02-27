package org.example.learn.concurrent.mutex;

import java.util.concurrent.locks.LockSupport;

public class PrintStrThree {

    final static char[] chars1 = "1234567".toCharArray();
    final static char[] chars2 = "ABCDEFG".toCharArray();

    static Thread t1 = null;
    static Thread t2 = null;

    public static void main(String[] args) {

        t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (char c : chars1) {
                    LockSupport.park(); // 阻塞自己
                    System.out.print(c);
                    LockSupport.unpark(t2); // 释放t2
                }
            }
        }, "t1");

        t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (char c : chars2) {

                    System.out.print(c);
                    LockSupport.unpark(t1); // 释放t1
                    LockSupport.park(); // 阻塞自己x
                }
            }
        }, "t2");

        t1.start();
        t2.start();
    }
}
