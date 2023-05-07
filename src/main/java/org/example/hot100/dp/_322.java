package org.example.hot100.dp;

import java.util.Arrays;

public class _322 {

    /**
     * 零钱兑换
     *
     * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
     *
     * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
     *
     * 你可以认为每种硬币的数量是无限的。
     */

    public static void main(String[] args) {
        _322 o = new _322();
        System.out.println(o.coinChange(new int[]{1,2,5}, 11));
//        System.out.println(o.coinChange(new int[]{2, 4}, 3));
//        System.out.println(o.coinChange(new int[]{186, 419, 83, 408}, 6249));
    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? - 1 : dp[amount];
    }
}
