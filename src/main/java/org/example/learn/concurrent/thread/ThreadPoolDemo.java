package org.example.learn.concurrent.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {
    public static void main(String[] args) {

//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        ExecutorService executorService = Executors.newScheduledThreadPool(2);

        // 初始化线程池
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        ThreadTask tt = new ThreadTask();

        // 向线程池添加新任务
        executorService.execute(tt);
        executorService.execute(tt);

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
