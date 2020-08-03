package org.example.leetcode.dp;

public class SellStock {
    /*
    121
        给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
        如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），
        设计一个算法来计算你所能获取的最大利润。
        注意：你不能在买入股票前卖出股票。
     */
    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int p : prices) {
            minPrice = Math.min(p, minPrice);
            maxProfit = Math.max(p - minPrice, maxProfit);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
//        int[] in = {7,1,5,3,6,4};
        int[] in = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(in));
    }
}
