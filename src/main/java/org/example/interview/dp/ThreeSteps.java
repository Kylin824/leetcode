package org.example.interview.dp;

public class ThreeSteps {
    public static int waysToStep(int n) {
        if (n == 0 || n == 1 || n == 2)
            return n;
        if (n == 3)
            return 4;
        long[] dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= n; i++) {
            dp[i] = (dp[i - 3] + dp[i - 2] + dp[i - 1]) % 1000000007;
        }
        return (int)dp[n];
    }

    public static int waysToStepOpt(int n) {
        long[] f = {1, 0, 0, 0};
        for (int i = 0; i < n; i++) {
            f[3] = f[2];
            f[2] = f[1];
            f[1] = f[0];
            f[0] = (f[1] + f[2] + f[3]) % 1000000007;
        }
        return (int)f[0];
    }

    public static void main(String[] args) {
        System.out.println(waysToStep(50));
    }
}
