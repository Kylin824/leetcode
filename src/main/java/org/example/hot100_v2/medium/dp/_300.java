package org.example.hot100_v2.medium.dp;

import java.util.Arrays;

/**
 * 最长严格递增子序列的长度。
 *
 * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 * @author kylin
 * @date 2026/7/12
 */

public class _300 {
    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1); //
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        _300 obj = new _300();
//        System.out.println(obj.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18})); // 4
        System.out.println(obj.lengthOfLIS(new int[]{0,1,0,3,2,3})); // 3
//        System.out.println(obj.lengthOfLIS(new int[]{7,7,7,7,7,7,7})); // 1
//        System.out.println(obj.lengthOfLIS(new int[]{4,10,4,3,8,9})); // 1
    }
}
