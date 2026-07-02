package org.example.hot100_v2.medium.dp;

/**
 * 整数 n ，返回 和为 n 的完全平方数的最少数量 。
 * @author kylin
 * @date 2026/7/2
 */

public class _279 {

    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        int start = 1;
        for (int i = 2; i <= n; i++) {
            int j = (int) Math.floor(Math.sqrt(i));
            if (j * j == i) {
                dp[i] = 1;
                start = j;
            } else {
                dp[i] = Integer.MAX_VALUE;
                for (int k = start; k >= 0; k--) {
                    dp[i] = Math.min(dp[i], dp[k * k] + dp[i - k * k]);
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numSquares(12)); // 3
        System.out.println(numSquares(13)); // 2
    }

}
