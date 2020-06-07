package org.example.learn.current;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    private static Lock lock = new ReentrantLock();

    private static int state = 0;

    public static void main(String[] args) {
        new ThreadA().start();
        new ThreadB().start();
        new ThreadC().start();
    }


    static class ThreadA extends Thread {
        public void run() {
            for (int i = 0; i < 5;) {
                try {
                    lock.lock();
                    while (state % 3 == 0) {
                        System.out.print("A");
                        state++;
                        i++;
                    }
                }
                finally {
                    lock.unlock();
                }
            }
        }
    }
    static class ThreadB extends Thread {
        public void run() {
            for (int i = 0; i < 5;) {
                try {
                    lock.lock();
                    while (state % 3 == 1) {
                        System.out.print("B");
                        state++;
                        i++;
                    }
                }
                finally {
                    lock.unlock();
                }
            }
        }
    }
    static class ThreadC extends Thread {
        public void run() {
            for (int i = 0; i < 5;) {
                try {
                    lock.lock();
                    while (state % 3 == 2) {
                        System.out.print("C");
                        state++;
                        i++;
                    }
                }
                finally {
                    lock.unlock();
                }
            }
        }
    }

}
