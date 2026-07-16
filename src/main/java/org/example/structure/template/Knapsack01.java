package org.example.structure.template;

import java.util.Arrays;

/**
 * @author kylin
 * @date 2026/7/16
 */
public class Knapsack01 {

    public static int knapsack(int W, int[] weights, int[] values) {
        int n = weights.length;
        int[] dp = new int[W + 1];

        for (int i = 0; i < n; i++) {
            // 倒序遍历！从 W 到 weights[i]，确保每个物品只用一次
            for (int j = W; j >= weights[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weights[i]] + values[i]);
            }
            System.out.println(Arrays.toString(dp));
        }

        return dp[W];
    }

    public static void main(String[] args) {
        int W = 5;
//        int[] weights = {2, 3, 4};
//        int[] values = {6, 10, 12};
        int[] weights = {4, 3, 2};
        int[] values = {12, 10, 6};
        System.out.println(knapsack(W, weights, values)); // 输出 16
    }
}
