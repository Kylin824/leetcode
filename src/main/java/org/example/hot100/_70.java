package org.example.hot100;

public class _70 {

    /**
     * 转移方程：dp[n] = dp[n−1] + dp[n−2]
     * 初始状态：dp[0] = 1; dp[1] = 1; dp[2] = 2;
     *
     * @param n
     * @return
     */

    // dp
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }


}
