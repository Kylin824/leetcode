package org.example.learn.current;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicLearn {

    private static AtomicInteger count = new AtomicInteger(0);

    public void increase() {
        count.incrementAndGet();
    }

    public static void main(String[] args) {

    }
}

class ThreadA extends Thread {
    public void run() {
        for (int i = 0; i < 5;) {
        }
    }
}


