package org.example.company.alibaba;

import java.util.Scanner;

public class ProblemOne {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int n = in.nextInt();
            int m = in.nextInt();
//            int[][] dp = new int[m][n];
//            for (int i = 0; i < m; i++) {
//                dp[i][0] = 1;
//            }
//            for (int i = 0; i < n; i++) {
//                dp[0][i] = 1;
//            }
//
//            for (int i = 1; i < m; i++) {
//                for (int j = 1; j < n; j++) {
//                    if (i > j) {
//                        // 盘子i多于苹果j
//                        dp[i][j] = dp[i - 1][j];
//                    } else if (i == j) {
//                        // 盘子i等于苹果j
//                        dp[i][j] = dp[i - 1][j] + 1;
//                    } else {
//                        // 苹果j多于等于盘子i
//                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1 - i]; // 每个盘子放一个苹果
//                    }
//                }
//            }
//            System.out.println(dp[m - 1][n - 1]);
            int sum = count(n, m);
            System.out.println((int) (sum % (Math.pow(10, 9) + 7)));
//            System.out.println(sum);
        }
    }

    public static int count(int n, int m) {
        int ret = 1;
        if (n == 1) {
            return 1;
        }
        if (n >= m) {
            while (m > 0) {
                ret *= n;
                n--;
                m--;
            }
            return ret;
        } else {
            ret = count(n, m - n) + count(n - 1, m);
            return ret;
        }
    }



}
