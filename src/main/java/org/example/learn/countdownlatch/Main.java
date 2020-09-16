package org.example.learn.countdownlatch;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class Main {
    //用于聚合所有的统计指标
    private static Map map = new HashMap();
    //创建计数器，这里需要统计4个指标
    private static CountDownLatch countDownLatch = new CountDownLatch(4);

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Thread countUserThread = new Thread(new Runnable() {
            public void run() {
                try {
                    System.out.println("1 正在统计新增用户数量");
                    Thread.sleep(4000);//任务执行需要3秒
                    map.put("userNumber", 1);//保存结果值
                    countDownLatch.countDown();//标记已经完成一个任务
                    System.out.println("统计新增用户数量完毕");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread countOrderThread = new Thread(new Runnable() {
            public void run() {
                try {
                    System.out.println("2 正在统计订单数量");
                    Thread.sleep(2000);//任务执行需要3秒
                    map.put("countOrder", 2);//保存结果值
                    countDownLatch.countDown();//标记已经完成一个任务
                    System.out.println("统计订单数量完毕");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread countGoodsThread = new Thread(new Runnable() {
            public void run() {
                try {
                    System.out.println("3 正在统计商品销量");
                    Thread.sleep(3000);//任务执行需要3秒
                    map.put("countGoods", 3);//保存结果值
                    countDownLatch.countDown();//标记已经完成一个任务
                    System.out.println("统计商品销量完毕");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread countmoneyThread = new Thread(new Runnable() {
            public void run() {
                try {
                    System.out.println("4 正在统计总销售额");
                    Thread.sleep(1000);//任务执行需要3秒
                    map.put("countmoney", 4);//保存结果值
                    countDownLatch.countDown();//标记已经完成一个任务
                    System.out.println("统计销售额完毕");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        //启动4个子线程执行任务
        countUserThread.start();
        countGoodsThread.start();
        countOrderThread.start();
        countmoneyThread.start();
        try {
            countDownLatch.await(); // 阻塞当前线程，直到countDown为0被唤醒
            long endTime = System.currentTimeMillis();
            System.out.println("------统计指标全部完成--------");
            System.out.println("统计结果为：" + map.toString());
            System.out.println("任务总执行时间为" + (endTime - startTime) / 1000 + "秒");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
