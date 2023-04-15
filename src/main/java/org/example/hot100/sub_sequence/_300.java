package org.example.hot100.sub_sequence;

import java.util.Arrays;

public class _300 {

    /**
     * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
     *
     * 示例 1：
     * <p>
     * 输入：nums = [10,9,2,5,3,7,101,18]
     * 输出：4
     * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
     *
     * 示例 2：
     * <p>
     * 输入：nums = [0,1,0,3,2,3]
     * 输出：4
     *
     * 示例 3：
     * <p>
     * 输入：nums = [7,7,7,7,7,7,7]
     * 输出：1
     */

    public static void main(String[] args) {
        _300 o = new _300();

        System.out.println(o.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18})); // 4
        System.out.println(o.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3})); // 4
        System.out.println(o.lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7})); // 1
        System.out.println(o.lengthOfLIS(new int[]{0})); // 1
        System.out.println(o.lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6})); // 6
    }

    public int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, 1);
        int count = 1;
        dp[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    dp[i] = Math.max(dp[j], dp[i]);
                    break;
                }
                if (nums[i] < nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    count = Math.max(dp[i], count);
                }
            }
        }
        return count;
    }
}
