package org.example.learn.proxy.cglib;

public class Main {
    public static void main(String[] args) {
        UserDao user = new UserDaoImpl();
        CglibHandler handler = new CglibHandler();
        UserDaoImpl proxy = (UserDaoImpl)handler.getProxy(user.getClass());
        proxy.add();
    }
}
