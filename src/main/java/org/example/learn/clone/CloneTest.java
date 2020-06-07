package org.example.learn.clone;

/**
 * Hello world!
 *
 */
public class CloneTest
{
    public static void main( String[] args ) throws Exception
    {
        Student stu1 = new Student("s1", 18);
        Student stu2 = (Student)stu1.clone();
        System.out.println(stu2.getName());
        System.out.println(stu2.getAge());
        System.out.println(stu1.hashCode());
        System.out.println(stu2.hashCode());
        stu2.setAge(20);
        System.out.println("stu1: " + stu1.getName() + " " + stu1.getAge());
        System.out.println("stu2: " + stu2.getName() + " " + stu2.getAge());
        //stu2.setName("sssssssss");
        System.out.println("stu1: " + stu1.getName() + " " + stu1.getAge());
        System.out.println("stu2: " + stu2.getName() + " " + stu2.getAge());
        System.out.println(stu1.getName().hashCode());
        System.out.println(stu2.getName().hashCode());

    }
}
