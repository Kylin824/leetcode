package org.example.hot100_v2.medium.dp;

/**
 * 打家劫舍II ，所有房屋围成一圈
 *
 * @author kylin
 * @date 2026/7/10
 */
public class _213 {

    public static int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp1 = new int[nums.length]; // 0 ~ n-1
        dp1[0] = 0;
        dp1[1] = nums[0];
        for (int i = 2; i <= nums.length - 1; i++) {
            dp1[i] = Math.max(dp1[i - 2] + nums[i - 1], dp1[i - 1]);
        }
        int[] dp2 = new int[nums.length]; // 1 ~ n
        dp2[0] = 0;
        dp2[1] = nums[1];
        for (int i = 2; i <= nums.length - 1; i++) {
            dp2[i] = Math.max(dp2[i - 2] + nums[i], dp2[i - 1]);
        }
        return Math.max(dp1[nums.length - 1], dp2[nums.length - 1]);
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{2,3,2}));
    }
}
