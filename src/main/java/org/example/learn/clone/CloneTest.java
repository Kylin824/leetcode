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
        // 1和2的hashcode不同，说明2创建了新的内存空间
        System.out.println("stu1 hashcode: " + stu1.hashCode());
        System.out.println("stu2 hashcode: " + stu2.hashCode());
        // String类型hashcode相同，说明是两个name是同一个引用
        // ps:int型的age就是不同的
        System.out.println("stu1 name hash: " + stu1.getName().hashCode());
        System.out.println("stu2 name hash: " + stu2.getName().hashCode());

        stu2.setName("jony");
        System.out.println("stu1 name: " + stu1.getName());
        System.out.println("stu2 name: " + stu2.getName());

//        stu2.setName("sssssssss");
        System.out.println("stu1: " + stu1.getName() + " " + stu1.getAge());
        System.out.println("stu2: " + stu2.getName() + " " + stu2.getAge());
        System.out.println(stu1.getName().hashCode());
        System.out.println(stu2.getName().hashCode());

    }
}
