package org.example.learn.reflect;


import lombok.Data;
import org.example.company.alibaba.Student;
import sun.reflect.Reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Properties;

@Data
public class ClassLoaderDemo {

    private String id;

    public static void main(String[] args) throws Exception {

        // Class对象 & ClassLoader对象
        ClassLoader loader = ClassLoaderDemo.class.getClassLoader();

        // AppClassLoader
        System.out.println(loader);

        // ExtClassLoader
        System.out.println(loader.getParent());

//        Class<ClassLoaderDemo> classLoaderDemoClass = ClassLoaderDemo.class;
//        ClassLoaderDemo classLoaderDemo = classLoaderDemoClass.newInstance();
//        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
//        ClassLoader stringClassLoader = String.class.getClassLoader();
//        System.out.println(stringClassLoader);
//        System.out.println(systemClassLoader);
//        ClassLoaderDemo classLoaderDemo1 = new ClassLoaderDemo();
//        Class<?> aClass = Class.forName("org.example.learn.reflect.ClassLoaderDemo");
//        Class<?> callerClass = Reflection.getCallerClass();
//        System.out.println(aClass);
//
//        System.out.println(callerClass);
//
//        System.out.println(classLoaderDemo);
//        System.out.println(classLoaderDemo1);

//        System.out.println(loader.toString());
//        System.out.println(loader.getParent().toString());
//        System.out.println(loader.getParent().getParent());
//
//        int[] array = {8, 10, 13, 16, 19, 20, 23, 26, 29, 33, 41};

        // get instance
//        Class<?> studentClass  = Class.forName("org.example.company.alibaba.Student");
//        Student student = (Student)studentClass.newInstance();
//        student.setName("kylin");
//        student.setAge(22);
//        student.setGender("man");
//        student.setScore(999);
//        System.out.println(student.toString());

//        // get constructor
//        Class<?> studentClass  = Class.forName("org.example.company.alibaba.Student");
//        Constructor<?> stuConstructor = studentClass.getDeclaredConstructor(String.class, String.class, Integer.class, Integer.class);
//        Constructor<?> stuConstructor1 = studentClass.getDeclaredConstructor(String.class, String.class, Integer.class);
//        stuConstructor.setAccessible(true);
//        Object stuObject = stuConstructor.newInstance("kylin", "man", 22, 666);
//        Student student = (Student) stuObject;
//        System.out.println(student.toString());

        // get method
        Class studentClass = Class.forName("org.example.company.alibaba.Student");
        Annotation[] annotations = studentClass.getAnnotations();
//        studentClass.getAnnotation();
        Method methodBook = studentClass.getMethod("selfIntroduce", int.class); // 获取Method时，需要传入方法名+参数的Class类型
        Method methodBook1 = studentClass.getDeclaredMethod("selfIntroduce", int.class); // 获取Method时，需要传入方法名+参数的Class类型
        Student student = (Student)studentClass.newInstance();
        String ret = (String) methodBook.invoke(student, 0);
        System.out.println(ret);


    }

}








