package org.example.hot100_v2.medium.dp;


/**
 * 最大正方形
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 * @author kylin
 * @date 2026/7/21 0:50
 */

public class _221 {

    // 定义 dp[i][j] 表示以矩阵中第 i 行第 j 列作为 右下角 的最大正方形的边长。
    // dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1
    // 因为只有当左、上、左上三个方向都能构成足够大的正方形时，当前位置才能扩展出更大的正方形。
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        // 第一行和第一列只能形成1的正方形
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }
}
