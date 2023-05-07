package org.example.hot100.dp;

import java.util.Arrays;

public class _279 {

    // 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
    //
    //完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
    //

    public static void main(String[] args) {
        _279 o = new _279();

        System.out.println(o.numSquares(12));
    }


    public int numSquares(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int j = (int) Math.floor(Math.sqrt(i));
            if (i == j * j) {
                dp[i] = 1;
                continue;
            }
            for (int k = 1; k <= j; k++) {
                int count = dp[k * k] + dp[i - k * k];
                dp[i] = Math.min(dp[i], count);
            }
        }
        return dp[n];
    }
}
