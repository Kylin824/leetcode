package org.example.company.alibaba;

public class Student {
    private String name;
    private String gender;
    private Integer age;
    private Integer score;

    // 想调用clazz.newInstance()，必须保证编写类的时候有个无参构造。
    public Student() {
    }

    public Student(String name, String gender, Integer age, Integer score) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }

    public String selfIntroduce(int index) {
        String string = null;
        switch (index) {
            case 0:
                string = "index 0 !";
                break;
            case 1:
                string = "index 1 !";
                break;
            default:
                string = "index 2 !";
        }
        return string;
    }
}
