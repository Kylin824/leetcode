package org.example.learn.concurrent.mutex;

public class PrintStrOne {


    final static char[] chars1 = "1234567".toCharArray();
    final static char[] chars2 = "ABCDEFG".toCharArray();
    final static Object object = new Object();

    public static void main(String[] args) {

        new Thread(() -> {
            for (char c : chars1) {
                synchronized (object) {
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.print(c);
                    object.notifyAll();
                }
            }
        }).start();

        new Thread(() -> {
            for (char c : chars2) {
                synchronized (object) {
                    System.out.print(c);
                    object.notifyAll();
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }
}
