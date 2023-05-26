package org.example.hot100.dp;

/**
 * @author kylin
 * @date 2023/5/26
 */

public class _494 {

    /**
     * 目标和
     * <p>
     * 给你一个整数数组 nums 和一个整数 target 。
     * <p>
     * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
     * <p>
     * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
     * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,1,1,1,1], target = 3
     * 输出：5
     * 解释：一共有 5 种方法让最终目标和为 3 。
     * -1 + 1 + 1 + 1 + 1 = 3
     * +1 - 1 + 1 + 1 + 1 = 3
     * +1 + 1 - 1 + 1 + 1 = 3
     * +1 + 1 + 1 - 1 + 1 = 3
     * +1 + 1 + 1 + 1 - 1 = 3
     */

    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3)); // 5
        System.out.println(findTargetSumWays(new int[]{1}, 1)); // 1
        System.out.println(findTargetSumWays(new int[]{1, 0}, 1)); // 2
    }

    public static int findTargetSumWays(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        return find(nums, 0, target);
    }

    // 回溯
    public static int find(int[] nums, int i, int target) {
        if (i >= nums.length) {
            return 0;
        }
        if (i == nums.length - 1 && nums[i] == target && nums[i] == -target) {
            return 2;
        }
        if (i == nums.length - 1 && (nums[i] == target || nums[i] == -target)) {
            return 1;
        }
        return find(nums, i + 1, nums[i] + target) + find(nums, i + 1, target - nums[i]);
    }

    // dp 背包问题
    public static int findTargetSumWays1(int[] nums, int target) {
        int[] dp = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            dp[]
        }
    }

}
