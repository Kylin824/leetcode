package org.example;

public class Main {
    public static void main(String[] args) {
        int i = 2;
        int res = 0;
        switch (i) {
            case 1: res = res + i;
            case 2: res = res + i * 2;
            case 3: res = res + i * 3;
        }
        System.out.println(res);
    }
}
