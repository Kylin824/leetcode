package org.example.learn.concurrent.thread;

import java.text.DecimalFormat;

public class RunnableDemo {
    public static void main(String[] args) {
//        MyThread mt = new MyThread();
//        Thread t1 = new Thread(mt, "Thread-A");
//        Thread t2 = new Thread(mt, "Thread-B");
//        t1.start();
//        t2.start();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("hello lambda");
//            }
//        }).start();

//        new Thread(() -> System.out.println("hello lambda"));
        float money1 = 3.3333f;
        float money2 = 6.6666f;
        System.out.println(money1 * 10000);
        int mon1 = (int)(money1 * 10000);
        int mon2 = (int)(money2 * 10000);
        System.out.println(money1 + money2);
        DecimalFormat df=new DecimalFormat("0.0000");//设置保留位数
        System.out.println((mon1+mon2) / 10000);
        System.out.println(mon1+mon2);
        System.out.println(df.format((float)(mon1+mon2) / 10000));
    }
}

class MyThread implements Runnable {

    private int ticket = 10;

    // 重写run方法
    @Override
    public void run() {
        for(int i = 0; i < 100; i++) {
            if(ticket > 0) {
                System.out.println(Thread.currentThread().getName() + " 卖票--> " + ticket);
                ticket--;
            }
        }
    }
}
