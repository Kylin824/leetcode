package org.example.learn.proxy.cglib;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        CglibHandler handler = new CglibHandler();
        User proxy = (User)handler.getProxy(user.getClass());
        proxy.add();
    }
}



