package org.example.learn.concurrent.condition;

public class Producer implements Runnable{


    @Override
    public void run() {

        synchronized (Main.class) {


            Main.pool.add("str");

        }
    }
}
