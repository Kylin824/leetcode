package org.example.learn.concurrent;
import lombok.SneakyThrows;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicLearn {

    private static final AtomicInteger count = new AtomicInteger(0);

    public void increase() {
        count.incrementAndGet();
    }

    public static void main(String[] args) throws InterruptedException {

        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {

                }
            }
        }).start();

        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    Thread.sleep(1);
                    count.getAndIncrement();
                }
            }
        }).start();

        System.out.println(count);
        Thread.sleep(5000);
        System.out.println(count);
    }
}


