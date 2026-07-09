package org.example.hot100_v2.medium.dp;

/**
 * @author kylin
 * @date 2026/7/9
 */

public class _72 {

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                // 如果w1的第i个字符 == w2的第j个字符 那w1[0..i] 到 w2[0..j]的编辑距离 等于 w1[0..i-1]到w2[0..j-1]
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                // 否则，有三种情况：
                // 1. w1[i]替换成w2[j]，那距离等于 w1[0..i-1]到w2[0..j-1]的距离 + 1
                // 2. w1[i]删掉，那距离等于w1[0..i-1]到w2[0..j]的距离 + 1
                // 3. w1[i]插入w2[j]，那距离等于w1[0..i]到w2[0..j-1]的距离 + 1
                // 取这三者中最小距离，即为dp[i][j]
                // 表示：word1 的前 i 个字符 转换成 word2 的前 j 个字符 所需的最少操作数。
                else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[m][n];
    }



}
