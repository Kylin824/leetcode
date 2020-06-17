package org.example.learn.concurrent.thread;

public class ThreadDemo {
    public static void main(String[] args) {

        SubThread mt1= new SubThread("一号窗口");
        SubThread mt2= new SubThread("二号窗口");

        mt1.start();  // 使用start()调用，而不是直接调用run()
        mt2.start();
    }
}

class SubThread extends Thread{

    private int ticket = 10;
    private String name;

    // 构造方法添加线程名
    public SubThread(String name){
        this.name =name;
    }

    // 重写run方法
    @Override
    public void run() {
        for(int i = 0; i < 100; i++) {
            if(this.ticket > 0) {
                System.out.println(this.name+"卖票---->"+(this.ticket--));
            }
        }
    }
}


