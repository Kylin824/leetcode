package org.example.interview.array;

public class MaxSubArray {
    /*
    面试题 16.17. 连续数列
    给定一个整数数组，找出总和最大的连续数列，并返回总和。

    示例：
    输入： [-2,1,-3,4,-1,2,1,-5,4]
    输出： 6
    解释： 连续子数组 [4,-1,2,1] 的和最大，为 6。

    输入： [-1]
    输出： -1
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

    public static int maxSubArrayOpt(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sum = Math.max(sum, nums[i]);
            max = Math.max(sum, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {-2,1};
        System.out.println(maxSubArray(arr));
    }
}
