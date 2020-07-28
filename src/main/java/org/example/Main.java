package org.example;

import java.util.Random;

public class Main {
    public static void main(String[] args){
        System.out.println(Math.round(1.3));
        Random random = new Random();
        System.out.println(random.nextFloat());

        System.out.println(String.format("%.2f", random.nextFloat()));
        System.out.printf("%.2f", random.nextFloat());
    }
}
