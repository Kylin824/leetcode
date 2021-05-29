package org.example.learn.proxy.dynamicProxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyHandler implements InvocationHandler {

    private Object target; // 被代理的真实对象

    public ProxyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("jdk 调用之前，打印日志");
        Object result = method.invoke(target, args);
        System.out.println("jdk 调用之后，清理数据");
        return result;
    }

    public static void main(String[] args) {
        User target = new User();
        ProxyHandler proxyHandler = new ProxyHandler(target);
        UserInterface userProxy = (UserInterface) Proxy.newProxyInstance(User.class.getClassLoader(), User.class.getInterfaces(), proxyHandler);
        userProxy.add();
    }
}
