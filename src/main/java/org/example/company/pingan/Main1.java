package org.example.company.pingan;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            try {
                float res = (float)Math.max(Math.max(a + b, b), c) / (Math.max(Math.max(a, b + c), c) + Math.max(Math.max(a, b), b + c));
                System.out.printf("%.2f\n", res);
            }
            catch (Exception e) {
                System.out.println("ERROR");
            }
        }
    }
}
