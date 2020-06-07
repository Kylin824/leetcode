package org.example.learn.current.synchron;

/**
 * 类对象锁之二：对Class对象加锁，实现类对象锁
 */

public class SynchronizedClassClass implements Runnable{

    @Override
    public void run() {
        method();
    }

    public void method() {
        synchronized (SynchronizedClassClass.class) {
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
