package org.example.learn.proxy.static_proxy;

public class UserDaoImpl implements UserDao{
    @Override
    public void add() {
        System.out.println("add an user!");
    }
}
