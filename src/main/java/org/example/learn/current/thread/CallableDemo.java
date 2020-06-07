package org.example.learn.current.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        MyCallableThread mc = new MyCallableThread();

        // 将自定义的线程类注册进入到FutureTask类中
        FutureTask<String> ft1 = new FutureTask<String>(mc);
        FutureTask<String> ft2 = new FutureTask<String>(mc);

        // 将FutureTask类的实例注册进入Thread中运行
        new Thread(ft1, "Thread-A").start();
        new Thread(ft2, "Thread-B").start();

        // FutureTask<V>中的get()方法获取自定义线程运行结束的返回值
        String res1 = ft1.get();
        String res2 = ft2.get();

        System.out.println(res1);
        System.out.println(res2);

    }
}

class MyCallableThread implements Callable<String> {

    private int ticket = 10;

    public String call() throws Exception {
        String res;
        for(int i = 0; i < 100; i++) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName()+" 卖票----> "+(ticket--));
            }
        }
        res = Thread.currentThread().getName() + " ticket sold out!";
        return res;
    }
}
