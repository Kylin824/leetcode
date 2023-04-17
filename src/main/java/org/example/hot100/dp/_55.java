package org.example.hot100.dp;

import java.util.Arrays;

public class _55 {

    /**
     * 跳跃游戏
     *
     * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
     *
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     *
     * 判断你是否能够到达最后一个下标。
     */

    public static void main(String[] args) {
        _55 o = new _55();
        System.out.println(o.canJump1(new int[]{2, 3, 1, 1, 4})); // true
        System.out.println(o.canJump1(new int[]{3, 2, 1, 0, 4})); // false
        System.out.println(o.canJump1(new int[]{0, 2, 3})); // false
    }

    // dp
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] && j + nums[j] >= i) {
                    dp[i] = true;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[dp.length - 1];
    }

    // 贪心
    public boolean canJump1(int[] nums) {
        int maxRight = 0; // 从左到右最大能走到的位置
        for (int i = 0; i < nums.length; i++) {
            if (i > maxRight) {
                return false;
            }
            maxRight = Math.max(maxRight, i + nums[i]);
        }
        return true;
    }

}
