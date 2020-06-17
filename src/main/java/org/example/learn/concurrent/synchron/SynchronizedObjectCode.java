package org.example.learn.concurrent.synchron;

/**
 * 对象锁之一：使用this或自定义Object对象作为lock，实现同一个类的实例对象之间的同步锁
 */
public class SynchronizedObjectCode implements Runnable {

    Object lock = new Object();

    @Override
    public void run() {
        method();
    }

    public void method() {
        synchronized (lock) {
            System.out.println("this is " + Thread.currentThread().getName() + " runnig");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("this is " + Thread.currentThread().getName() + " finished");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedClassStatic instance = new SynchronizedClassStatic();
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("finished");
    }
}
