package org.example.learn.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class InvocationHandlerImpl implements InvocationHandler {

    private Object real; // 被代理的真实对象

    public InvocationHandlerImpl(Object real) {
        this.real = real;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("调用之前，打印日志");
        Object result = method.invoke(real, args);
        System.out.println("调用之后，清理数据");
        return result;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(real.getClass().getClassLoader(), real.getClass().getInterfaces(), this);
    }
}
