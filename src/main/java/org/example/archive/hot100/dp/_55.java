package org.example.archive.hot100.dp;

import java.util.Arrays;

//给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
//
// 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
//
// 示例 1：
//
//输入：nums = [2,3,1,1,4]
//输出：true
//解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
//
// 示例 2：
//
//输入：nums = [3,2,1,0,4]
//输出：false
//解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
//
// 提示：
//
// 1 <= nums.length <= 10⁴
// 0 <= nums[i] <= 10⁵
//
// Related Topics 贪心 数组 动态规划 👍 2677 👎 0

public class _55 {

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
    // 每一个位置都尝试最远距离并记录
    // 每一个位置与当前最远距离比较，小于最远距离则是可达的
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


    public static void main(String[] args) {
        _55 o = new _55();
        System.out.println(o.canJump1(new int[]{2, 3, 1, 1, 4})); // true
        System.out.println(o.canJump1(new int[]{3, 2, 1, 0, 4})); // false
        System.out.println(o.canJump1(new int[]{0, 2, 3})); // false
    }

}
