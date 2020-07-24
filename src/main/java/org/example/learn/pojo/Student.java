package org.example.learn.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    public int id;
    public String name;
    public String password;
    public int age;
}
