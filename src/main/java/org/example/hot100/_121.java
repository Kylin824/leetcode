package org.example.hot100;

public class _121 {


    // dp
    public int maxProfit(int[] prices) {

        if (prices.length == 0) {
            return 0;
        }

        int[] dp = new int[prices.length];

        int minPrice = prices[0];
        dp[0] = 0;

        for (int i = 1; i <= prices.length - 1; i++) {
            minPrice = Math.min(prices[i], minPrice);
            dp[i] = Math.max(dp[i - 1], prices[i] - minPrice);
        }

        return dp[prices.length - 1];
    }
}
