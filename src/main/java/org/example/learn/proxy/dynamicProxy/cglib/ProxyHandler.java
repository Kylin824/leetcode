package org.example.learn.proxy.dynamicProxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyHandler implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib 调用之前，打印日志");
        //通过代理类调用父类中的方法
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("cglib 调用之后，清理数据");
        return result;
    }

    public static void main(String[] args) {

        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(new ProxyHandler());
        enhancer.setSuperclass(User.class);
        User userProxy = (User)enhancer.create();
        userProxy.add();
    }
}
