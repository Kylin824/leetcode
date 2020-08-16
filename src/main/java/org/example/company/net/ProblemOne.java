package org.example.company.net;

import java.util.Scanner;

public class ProblemOne {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int sum = 0;
            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                int ai = in.nextInt();
                sum += (ai - 3) / 2 + 1 ;
            }
            System.out.println(sum);
        }
    }

    public static int getSplitNum(int n) {
        if (n <= 1) {
            return 0;
        }
        if (n == 2 || n == 3) {
            return 1;
        }
        if (n == 4) {
            return 2;
        }
        return Math.max(Math.max(getSplitNum(n - 2), getSplitNum(n - 3)), 1) + 1;
    }

}
