package org.example.learn.proxy.static_proxy;

public class UserDaoProxy implements UserDao{
    public UserDao target;

    public UserDaoProxy(UserDao target) {
        this.target = target;
    }

    @Override
    public void add() {
        System.out.println("记录日志");
        target.add();
        System.out.println("清理数据");
    }
}
