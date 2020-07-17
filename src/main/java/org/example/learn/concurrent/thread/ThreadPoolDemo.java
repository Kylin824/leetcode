package org.example.learn.concurrent.thread;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolDemo {

    public static void main(String[] args) {
        // 初始化线程池
//      ExecutorService executorService = Executors.newFixedThreadPool(2);
        ExecutorService executorService = Executors.newCachedThreadPool();
        ThreadTask tt1 = new ThreadTask();
        ThreadTask tt2 = new ThreadTask();

        // 向线程池添加新任务
        executorService.execute(tt1);
        executorService.execute(tt2);

        BigInteger bi = new BigInteger(String.valueOf(100));
        System.out.println(bi.intValue());
        // 销毁线程池
        executorService.shutdown();
    }
}

//class ThreadTask implements Runnable {
//
//    private int ticket = 10;
//
//    public void run() {
//        for(int i = 0; i < 100; i++) {
//            if (ticket > 0) {
//                System.out.println(Thread.currentThread().getName()+" 卖票----> "+(ticket--));
//            }
//        }
//    }
//}

class ThreadTask extends Thread {

    private int ticket = 10;

    public void run() {
        for(int i = 0; i < 100; i++) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName()+" 卖票----> "+(ticket--));
            }
        }
    }
}
