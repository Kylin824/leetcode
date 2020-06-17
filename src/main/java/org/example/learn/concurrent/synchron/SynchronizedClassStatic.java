package org.example.learn.concurrent.synchron;

/**
 * 类对象锁之一：对静态方法加锁，实现类对象锁
 */
public class SynchronizedClassStatic implements Runnable{

    @Override
    public void run() {
        method();
    }

    public synchronized static void method() {
        System.out.println("this is " + Thread.currentThread().getName() + " runnig");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("this is " + Thread.currentThread().getName() + " finished");
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedClassStatic instance1 = new SynchronizedClassStatic();
        SynchronizedClassStatic instance2 = new SynchronizedClassStatic();
        Thread t1 = new Thread(instance1);
        Thread t2 = new Thread(instance2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("finished");

    }
}
