package org.example.company.huawei.dp;

import java.util.Scanner;

public class Walking {
    /*
    HJ91 计算n x m的棋盘格子（n为横向的格子数，m为竖向的格子数）
    沿着各自边缘线从左上角走到右下角
    总共有多少种走法，要求不能走回头路，即：只能往右和往下走，不能往左和往上走。
     */

    /*
        机器人走格子问题
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt() + 1;
            int m = sc.nextInt() + 1;
            int[][] dp = new int[m][n];
            for (int i = 0; i < m; i++) {
                dp[i][0] = 1;
            }
            for (int i = 0; i < n; i++) {
                dp[0][i] = 1;
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
            System.out.println(dp[m - 1][n - 1]);
        }
    }
}
