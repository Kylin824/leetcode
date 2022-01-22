package org.example.learn.threadlocal;

public class ThreadLocalDemo {
    public static void main(String[] args) throws InterruptedException {

        // 这些ThreadLocal所有线程都能用  但是每个线程可以存自己的值
        // 一个threadlocal就是一个map  key是线程  value是线程set的值 互不干扰
        ThreadLocal<Integer> threadLocal1 = new ThreadLocal<>();
        ThreadLocal<Integer> threadLocal2 = new ThreadLocal<>();
        ThreadLocal<Integer> mainThreadLocal = new ThreadLocal<>();

        new Thread(() -> {
            threadLocal1.set(1);
            threadLocal2.set(2);
            System.out.println(Thread.currentThread().getName() + " : " + threadLocal1.get());
            System.out.println(Thread.currentThread().getName() + " : " + threadLocal2.get());
        } ).start();

        Thread.sleep(3000);
        mainThreadLocal.set(99);

        new Thread(() -> {
            threadLocal1.set(10);
            System.out.println(Thread.currentThread().getName() + " : " + threadLocal1.get());
            System.out.println(Thread.currentThread().getName() + " : " + threadLocal2.get());
            threadLocal1.remove();
            System.out.println(Thread.currentThread().getName() + " : " + threadLocal1.get());
        } ).start();

        // 当前线程是拿不到 threadLocal2的值的
        System.out.println(Thread.currentThread().getName() + " : " + threadLocal2.get());
        System.out.println(Thread.currentThread().getName() + " : " + mainThreadLocal.get());
    }
}
