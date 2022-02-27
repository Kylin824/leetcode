package org.example.learn.concurrent.mutex;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrintStrTwo {

    final static char[] chars1 = "1234567".toCharArray();
    final static char[] chars2 = "ABCDEFG".toCharArray();

    final static ReentrantLock lock = new ReentrantLock();
    final static Condition mutex = lock.newCondition();

    public static void main(String[] args) {
        new Thread(() -> {
            for (char c : chars1) {
                lock.lock();
                try {
                    mutex.await();
                    System.out.print(c);
                    mutex.signal();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    lock.unlock();
                }
            }
        }).start();

        new Thread(() -> {
            for (char c : chars2) {
                lock.lock();
                try {
                    System.out.print(c);
                    mutex.signal();
                    mutex.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }).start();
    }
}
