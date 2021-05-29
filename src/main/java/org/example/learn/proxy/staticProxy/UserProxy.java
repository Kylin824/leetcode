package org.example.learn.proxy.staticProxy;

public class UserProxy implements UserInterface {
    public UserInterface target;

    public UserProxy(UserInterface target) {
        this.target = target;
    }

    @Override
    public void add() {
        System.out.println("记录日志");
        target.add();
        System.out.println("清理数据");
    }

    public static void main(String[] args) {
        User target = new User();
        UserProxy userProxy = new UserProxy(target);
        userProxy.add();
    }
}
