package org.example.leetcode.dp;

public class MaxSubArray {
    /*
       53. 最大子序和
        输入: [-2,1,-3,4,-1,2,1,-5,4]
        输出: 6
        解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     */
    /*
        原数组   [-2, 1, -3, 4, -1, 2, 1, -5, 4]
        dp数组  [-2, 1, -2, 4, 3, 5, 6, 1, 5] max = 6;
     */
    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }


    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(arr));
    }
}
