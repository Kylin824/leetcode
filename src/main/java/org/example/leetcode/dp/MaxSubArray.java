package org.example.leetcode.dp;

import java.security.interfaces.ECKey;

public class MaxSubArray {

    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            max = Math.max(max, dp[i]);
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i] + " ");
        }
        return max;
    }

    public static void main(String[] args) {
        int[] in = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(in));
    }
}
