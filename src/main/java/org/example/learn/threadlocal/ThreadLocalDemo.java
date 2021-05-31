package org.example.learn.threadlocal;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ThreadLocalDemo {
    public static void main(String[] args) {

        ThreadLocal<Integer> threadLocal1 = new ThreadLocal<>();
        ThreadLocal<Integer> threadLocal2 = new ThreadLocal<>();

        new Thread(() -> {
            threadLocal1.set(1);
            threadLocal2.set(2);
            System.out.println(Thread.currentThread().getName() + " : " + threadLocal1.get());
            System.out.println(Thread.currentThread().getName() + " : " + threadLocal2.get());
        } ).start();

        new Thread(() -> {
            threadLocal1.set(10);
            System.out.println(Thread.currentThread().getName() + " : " + threadLocal1.get());
            System.out.println(Thread.currentThread().getName() + " : " + threadLocal2.get());
            threadLocal1.remove();
        } ).start();

        System.out.println(Thread.currentThread().getName() + " : " + threadLocal2.get());
    }
}
