package org.example.learn.concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTemplate {
    public static void main(String[] args) {

        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            // 获取锁后执行操作
        }
        // 在finally块中释放锁，目的是保证在获取到锁之后，最终能够被释放。
        finally {
            lock.unlock();
        }
    }
}
