package org.example.learn.current;

public class DeadLockDemo {

    public static void main(String[] args) {
        RunnableThread rt = new RunnableThread();
        new Thread(rt, "Thread A").start();
        new Thread(rt, "Thread B").start();
        new Thread(rt, "Thread C").start();
    }

}


class RunnableThread implements Runnable {

    private int ticket = 50;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + " ticket: " + ticket--);
                }
            }
        }
    }
}
