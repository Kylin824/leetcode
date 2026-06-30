package org.example.hot100_v2.easy;

/**
 * 买卖股票最佳时机
 *
 * @author kylin
 * @date 2026/6/29
 */
public class _121 {

    public int maxProfit(int[] prices) {
        int min = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - min);
        }
        return maxProfit;
    }

}
