package org.example.company.huawei.dp;

import java.util.Scanner;

public class PutAppleInPlate {
    /*
    HJ61 M个同样的苹果放在N个同样的盘子里，允许有的盘子空着不放，问共有多少种不同的分法？
    （用K表示）5，1，1和1，5，1 是同一种分法。
     */
    /*
        dp[i][j] 表示第i个盘子放j个苹果的放法
        dp[i][j] =
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[][] dp = new int[n][m];
            for (int i = 0; i < n; i++) {
                dp[i][0] = 1;
            }
            for (int i = 0; i < m; i++) {
                dp[0][i] = 1;
            }
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    if (i > j) {
                        // 盘子i多于苹果j
                        dp[i][j] = dp[i - 1][j];
                    } else if (i == j) {
                        // 盘子i等于苹果j
                        dp[i][j] = dp[i - 1][j] + 1;
                    } else {
                        // 苹果j多于等于盘子i
                        //
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1 - i]; // 每个盘子放一个苹果
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(dp[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println(dp[n - 1][m - 1]);
        }
    }

    public static int count(int m, int n) {
        if (m == 0 || n == 1) // 苹果为0或者盘子为1
            return 1;
        if (n > m) // 盘子数大于苹果数，只用m个盘子
            return count(m, m);
        else // 苹果数大于盘子数，每个盘子放一个，count(m-n, n)
            return count(m, n - 1) + count(m - n, n);
    }
}
