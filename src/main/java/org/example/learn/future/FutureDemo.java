package org.example.learn.future;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.*;

public class FutureDemo {

    Random random = new Random();


    public static void main(String[] args) {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        FutureDemo f = new FutureDemo();

//        // 同步调用
//        System.out.println("begin time: " + dateTimeFormatter.format(LocalDateTime.now()));
//        double price = f.getPrice("p1");
//        System.out.println("do something else: " + dateTimeFormatter.format(LocalDateTime.now()));
//        System.out.println("price: " + price);
        System.out.println();

//        //异步调用
//        FutureTask<Double> futureTask = new FutureTask<>(new Callable<Double>() {
//            @Override
//            public Double call() throws Exception {
//                return f.getPrice("p2");
//            }
//        });
//        System.out.println("begin time: " + dateTimeFormatter.format(LocalDateTime.now()));
//        new Thread(futureTask).start();
//        System.out.println("do something else: " + dateTimeFormatter.format(LocalDateTime.now()));
//        try {
//            System.out.println("price: " + futureTask.get());
//            System.out.println("end time: " + dateTimeFormatter.format(LocalDateTime.now()));
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }


//        ExecutorService executorService = Executors.newCachedThreadPool();
//        Future<Double> future = executorService.submit(new Callable<Double>() {
//            @Override
//            public Double call() throws Exception {
//                return
//            }
//        })

        // CompleteFuture调用
        System.out.println("begin time: " + dateTimeFormatter.format(LocalDateTime.now()));
        CompletableFuture<Double> futurePrice = f.getPriceAsyn("p3");
        System.out.println("do something else: " + dateTimeFormatter.format(LocalDateTime.now()));
        try {
            System.out.println("price: " + futurePrice.get());
            CompletableFuture<String> futureString = futurePrice.thenApply(s -> s + " $$$$");
            System.out.println(futureString.get());
            System.out.println("end time: " + dateTimeFormatter.format(LocalDateTime.now()));
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void delay() {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public double getPrice(String product) {
        return calculatePrice(product);
    }

    public CompletableFuture<Double> getPriceAsyn(String product) {
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        // 启动一个线程去执行计算任务
        new Thread(() -> {
            try {
                double price = calculatePrice(product);
                futurePrice.complete(price);  // 当计算结束时，使用complete()方法结束对象并设置变量的值
            } catch (Exception ex) {
                futurePrice.completeExceptionally(ex); // 计算出错时抛出异常
            }
        }).start();
        // 不等计算任务结束，直接返回CompletableFuture实例
        return futurePrice;
    }

    // 使用 supplyAsync()工厂方法重写 getPriceAsync()
    public Future<Double> getPriceAsynPlus(String product) {
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }


    private double calculatePrice(String product) {
        delay();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }
}
