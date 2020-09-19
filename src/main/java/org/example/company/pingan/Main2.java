package org.example.company.pingan;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int n = sc.nextInt();
            if (n <= 4) {
                System.out.println(n);
                break;
            }
            int[] dp = new int[n];
            for (int i = 0; i < 4; i++) {
                dp[i] = i + 1;
            }
            for (int i = 4; i < n; i++) {
                dp[i] = dp[i - 3] + dp[i - 1];
            }
            System.out.println(dp[dp.length - 1]);
        }
    }

    public static int born(int n) {
        if (n == 0 || n == 1)
            return n;
        return born(n-1) + born(n-2);
    }
}

