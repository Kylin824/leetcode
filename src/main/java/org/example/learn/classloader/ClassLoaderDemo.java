package org.example.learn.classloader;


import org.example.company.alibaba.Student;

public class ClassLoaderDemo {

    public static void main(String[] args) throws Exception {
        ClassLoader loader = ClassLoaderDemo.class.getClassLoader();
        System.out.println(loader.toString());
        System.out.println(loader.getParent().toString());

        int[] array = {8, 10, 13, 16, 19, 20, 23, 26, 29, 33, 41};

        Class<?> studentClass  = Class.forName("org.example.company.alibaba.Student");
        Object stuObject = studentClass.newInstance();
        Student student = (Student)stuObject;
        student.setName("kylin");
        student.setAge(22);
        student.setGender("man");
        student.setScore(999);

        System.out.println(student.toString());

    }

}








