package org.example.dp;

public class zero_one_packet {
    public static void main(String[] args) {
        int n = 5;
        int c = 10;

        int[] w = {0, 1, 10, 2, 3, 4};
        int[] v = {0, 4, 8, 3, 2, 1};

        int[][] dp = new int[n+1][c+1];

        // DP过程
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= c; j++) {
                if (j >= w[i])
                    dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-w[i]]+v[i]);
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        System.out.println("二维数组解法：");
        // 输出DP数组
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= c; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }


        System.out.println("二维数组结果: " + dp[n][c]);

        System.out.println();
        System.out.println("一维数组解法：");

        // 优化版：使用一维数组
        int[] dp_one = new int[c+1];
        for (int i = 1; i <= n; i++) {
            for (int j = c; j >= 0; j--) {
                if (j >= w[i])
                    dp_one[j] = Math.max(dp_one[j], dp_one[j-w[i]]+v[i]);
            }
            System.out.print("第" + i + "轮dp: ");
            for (int j = 1; j <= c; j++) {
                System.out.print(dp_one[j] + " ");
            }
            System.out.println();
        }

        System.out.println("一维数组结果: " + dp_one[c]);
    }
}
