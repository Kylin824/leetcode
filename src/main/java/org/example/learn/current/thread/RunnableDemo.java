package org.example.learn.current.thread;

public class RunnableDemo {
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        Thread t1 = new Thread(mt, "Thread-A");
        Thread t2 = new Thread(mt, "Thread-B");
        t1.start();
        t2.start();
    }
}

class MyThread implements Runnable {

    private int ticket = 10;

    // 重写run方法
    public void run() {
        for(int i = 0; i < 100; i++) {
            if(ticket > 0) {
                System.out.println(Thread.currentThread().getName() + " 卖票--> " + ticket);
                ticket--;
            }
        }
    }
}
