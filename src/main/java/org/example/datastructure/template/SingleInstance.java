package org.example.datastructure.template;

public class SingleInstance {
    private static volatile SingleInstance instance = null;
    public SingleInstance() {
    }
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
