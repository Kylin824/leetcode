package org.example.learn.classloader;


import org.example.company.alibaba.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ClassLoaderDemo {

    public static void main(String[] args) throws Exception {

        ClassLoader loader = ClassLoaderDemo.class.getClassLoader();
        System.out.println(loader.toString());
        System.out.println(loader.getParent().toString());

        int[] array = {8, 10, 13, 16, 19, 20, 23, 26, 29, 33, 41};

//        // get instance
//        Class studentClass  = Class.forName("org.example.company.alibaba.Student");
//        Student student = (Student)studentClass.newInstance();
//        student.setName("kylin");
//        student.setAge(22);
//        student.setGender("man");
//        student.setScore(999);
//        System.out.println(student.toString());

//        // get constructor
//        Class<?> studentClass  = Class.forName("org.example.company.alibaba.Student");
//        Constructor<?> stuConstructor = studentClass.getDeclaredConstructor(String.class, String.class, Integer.class, Integer.class);
//        stuConstructor.setAccessible(true);
//        Object stuObject = stuConstructor.newInstance("kylin", "man", 22, 666);
//        Student student = (Student) stuObject;
//        System.out.println(student.toString());

        // get method
        Class studentClass = Class.forName("org.example.company.alibaba.Student");
        Method methodBook = studentClass.getMethod("selfIntroduce", int.class);
        Student student = (Student)studentClass.newInstance();
        String ret = (String) methodBook.invoke(student, 0);
        System.out.println(ret);


    }

}








