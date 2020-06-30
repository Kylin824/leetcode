package org.example.datastructure.dp;

public class Main {
    public static void main(String[] args) {
        int n = 5;
        int c = 10;

        int[] w = {0, 1, 10, 2, 3, 4};
        int[] v = {0, 4, 8, 3, 2, 1};

        int[][] dp = new int[n+1][c+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= c; j++) {
                if (j >= w[i])
                    dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-w[i]]+v[i]);
                else
                    dp[i][j]=dp[i-1][j];
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < c + 1; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("result: " + dp[n][c]);
    }
}
