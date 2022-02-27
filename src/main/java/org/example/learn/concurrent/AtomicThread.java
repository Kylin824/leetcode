package org.example.learn.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicThread {

    // public int num = 0;

    public AtomicInteger num = new AtomicInteger();

//    Lock lock = new ReentrantLock();

    public void increace() {
//        lock.lock();
//        try {
//            num++;
//        } finally{
//            lock.unlock();
//        }

        num.getAndIncrement();
    }

    public static void main(String[] args) {

        final AtomicThread test = new AtomicThread();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    test.increace();
                }
            }).start();
        }

        while (Thread.activeCount()>2) { //保证前面的线程都执行完
            Thread.yield();
        }

        System.out.println(test.num);
    }

}
