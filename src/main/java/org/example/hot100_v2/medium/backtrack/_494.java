package org.example.hot100_v2.medium.backtrack;

/**
 * 目标和
 *
 * 给你一个非负整数数组 nums 和一个整数 target 。
 *
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 *
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,1,1,1], target = 3
 * 输出：5
 * 解释：一共有 5 种方法让最终目标和为 3 。
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 *
 * @author kylin
 * @date 2026/7/21
 */
public class _494 {

    public int findTargetSumWays(int[] nums, int target) {
        return find(nums, target, 0);
    }

    public int find(int[] nums, int target, int start) {
        if (start >= nums.length) {
            return 0;
        }
        if (start == nums.length - 1) {
            if (nums[start] == target && nums[start] == -target) {
                return 2;
            }
            if (nums[start] == target || nums[start] == -target) {
                return 1;
            }
        }
        return find(nums, target + nums[start], start + 1) + find(nums, target - nums[start], start + 1);
    }

    public static void main(String[] args) {
        _494 solution = new _494();
        System.out.println(solution.findTargetSumWays(new int[]{0}, 0));
        System.out.println(solution.findTargetSumWays(new int[]{1,1,1,1,1}, 3));
    }

}
