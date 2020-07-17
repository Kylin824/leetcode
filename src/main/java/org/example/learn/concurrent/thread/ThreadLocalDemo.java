package org.example.learn.concurrent.thread;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ThreadLocalDemo {
    public static void main(String[] args) {
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

        Random random = new Random();
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                threadLocal.set(random.nextInt(100));
                System.out.println(Thread.currentThread().getName() + threadLocal.get());
//                try {
//                    TimeUnit.SECONDS.sleep(1);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
                threadLocal.remove();
            } ).start();
        }
        System.out.println(Thread.currentThread().getName() +  threadLocal.get());
    }
}
