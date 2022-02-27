package org.example.learn.reflect;

import java.lang.reflect.Method;

public class ReflectTest {

    public static void test1() {
        long startTime = System.currentTimeMillis();
        String string = "";
        for (long i = 0; i < 1000000000L; i++) {
            string.trim();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("普通方法调用10亿次耗时；" + (endTime - startTime));
    }

    public static void test2() {
        try {
            long startTime = System.currentTimeMillis();
            Class<?> clazz = String.class;
            String string = (String) clazz.newInstance();
            Method method = clazz.getMethod("trim", null);
            for (int i = 0; i < 1000000000L; i++) {
                method.invoke(string, null);
            }
            long endTime = System.currentTimeMillis();
            System.out.println("反射方法调用10亿次耗时:"+(endTime-startTime));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void test3() {
        try {
            long startTime = System.currentTimeMillis();
            Class<?> clazz = String.class;
            String string = (String) clazz.newInstance();
            Method method = clazz.getMethod("trim", null);
            method.setAccessible(true);
            for (int i = 0; i < 1000000000L; i++) {
                method.invoke(string, null);
            }
            long endTime = System.currentTimeMillis();
            System.out.println("反射方法不做安全检查调用10亿次耗时:"+(endTime-startTime));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

}
