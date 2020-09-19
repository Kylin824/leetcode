package org.example.learn.singleton;

public class SingletonInnerClass {
    /*
    懒汉式，通过内部类来构造实例
     */

    private static class InnerHolder {
        private static SingletonInnerClass instance = new SingletonInnerClass();
    }

    private SingletonInnerClass(){}

    public static SingletonInnerClass getInstance() {
        return InnerHolder.instance;
    }
}
