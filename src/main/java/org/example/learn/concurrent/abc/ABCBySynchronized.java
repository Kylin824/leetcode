package org.example.learn.concurrent.abc;

public class ABCBySynchronized {

    private static final Object lock = new Object();
    private static int state = 0;

    static class A implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10;) {
                synchronized (lock) {
                    while (state % 4 == 0) {
                        System.out.print("A");
                        state++;
                        i++;
                    }
                }
            }
        }
    }

    static class B implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10;) {
                synchronized (lock) {
                    while (state % 4 == 1) {
                        System.out.print("B");
                        state++;
                        i++;
                    }
                }
            }
        }
    }

    static class C implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10;) {
                synchronized (lock) {
                    while (state % 4 == 2) {
                        System.out.print("C");
                        state++;
                        i++;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new A()).start();
        new Thread(new C()).start();
        new Thread(new B()).start();
        new Thread(()-> {
            for (int i = 0; i < 10;) {
                synchronized (lock) {
                    while (state % 4 == 3) {
                        System.out.print("D");
                        state++;
                        i++;
                    }
                }
            }
        }).start();
    }

}
