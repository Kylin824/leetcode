package org.example.datastructure.template;

public class SingleInstance {
    // 指向自己实例的私有静态引用
    private static volatile SingleInstance instance = null;
    // 私有的构造方法
    private SingleInstance() {}
    // 返回自己实例的静态公有方法
    public static SingleInstance getInstance() {
        if (instance == null) {
            // 加锁
            synchronized (SingleInstance.class) {
                if (instance == null) {
                    instance = new SingleInstance();
                }
            }
        }
        return instance;
    }
}
