package org.example.structure.dp;

public class JumpFloor {
    public static void main(String[] args) {
        int target = 3;

        int[] dp = new int[target+1];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= target; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println(dp[target]);
    }
}
