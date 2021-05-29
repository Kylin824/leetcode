package org.example.learn.proxy.dynamicProxy.jdk;

public class User implements UserInterface {
    @Override
    public void add() {
        System.out.println("add an user!");
    }
}
