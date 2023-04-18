package org.example.hot100.dp;

import java.util.Arrays;

public class _64 {

    /**
     * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     * <p>
     * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
     * 输出：7
     * 解释：因为路径 1→3→1→1→1 的总和最小。
     * <p>
     * 输入：grid = [[1,2,3],[4,5,6]]
     * 输出：12
     */

    public static void main(String[] args) {
        _64 o = new _64();
        o.minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}});
    }

    // dp 秒了 跟62一样
    public int minPathSum(int[][] grid) {
        if (grid.length == 1) {
            return Arrays.stream(grid[0]).sum();
        }
        if (grid[0].length == 1) {
            return Arrays.stream(grid).map(g -> g[0]).reduce(0, Integer::sum);
        }

        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        for (int i = 1; i < m; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j] + grid[i][j], dp[i][j - 1] + grid[i][j]);
            }
        }
        System.out.println(Arrays.deepToString(dp));

        return dp[m - 1][n - 1];
    }
}
