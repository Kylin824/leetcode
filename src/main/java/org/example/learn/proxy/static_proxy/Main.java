package org.example.learn.proxy.static_proxy;

public class Main {
    public static void main(String[] args) {

        // 被代理的对象
        UserDao target = new UserDaoImpl();

        // 将对象传入代理类
        UserDaoProxy proxy = new UserDaoProxy(target);

        // 使用代理类内部调用被代理对象的方法
        proxy.add();

    }
}
