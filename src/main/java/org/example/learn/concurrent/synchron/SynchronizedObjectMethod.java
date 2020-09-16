package org.example.learn.concurrent.synchron;

/**
 * 对象锁之一：对方法加synchronized修饰，实现同步
 */

public class SynchronizedObjectMethod implements Runnable{

    @Override
    public void run() {
        method();
    }

    public synchronized void method() {
        System.out.println("this is " + Thread.currentThread().getName() + " runnig");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("this is " + Thread.currentThread().getName() + " finished");
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedObjectMethod instance = new SynchronizedObjectMethod();
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("finished");
    }
}

