package org.example.learn.proxy.cglib;

public class UserDaoImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("add an user!");
    }
}
