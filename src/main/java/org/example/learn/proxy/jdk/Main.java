package org.example.learn.proxy.jdk;

public class Main {

    public static void main(String[] args) {
        UserDao user = new UserDaoImpl();
        InvocationHandlerImpl handler = new InvocationHandlerImpl(user);
        UserDao proxy = (UserDao) handler.getProxy();
        proxy.add();
    }

}
