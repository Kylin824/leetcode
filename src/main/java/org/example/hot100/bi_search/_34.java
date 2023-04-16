package org.example.hot100.bi_search;

import java.util.Arrays;

public class _34 {

    /**
     * 在排序数组中查找元素的第一个和最后一个位置
     *
     * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
     *
     * 如果数组中不存在目标值 target，返回 [-1, -1]。
     *
     * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
     *
     * 示例 1：
     * 输入：nums = [5,7,7,8,8,10], target = 8
     * 输出：[3,4]
     *
     * 示例2：
     * 输入：nums = [5,7,7,8,8,10], target = 6
     * 输出：[-1,-1]
     *
     * 示例 3：
     * 输入：nums = [], target = 0
     * 输出：[-1,-1]
     *
     */

    public static void main(String[] args) {
        _34 o = new _34();
        System.out.println(Arrays.toString(o.searchRange(new int[]{5,7,7,8,8,10}, 8)));
        System.out.println(Arrays.toString(o.searchRange(new int[]{2,2}, 1)));
    }

    // https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/solution/zai-pai-xu-shu-zu-zhong-cha-zhao-yuan-su-de-di-3-4/689279
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};

        if (nums.length == 0) {
            return res;
        }

        int l = 0, r = nums.length - 1;

        // 找左边界
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] == target){
                r = mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
            }
        }
        // nums[r] 为 target 左边界 或为空
        if (r < 0 || nums[r] != target) {
            return res;
        }
        res[0] = r;

        l = 0;
        r = nums.length - 1;

        // 找右边界
        while (l < r) {
            int mid  = (l + r + 1) / 2;  // int mid  = (l + r) / 2 + 1; 效果相同
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] == target) {
                l = mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
            }
        }

        // 因为前面左边界已查到，保证了l不会越出数组长度
        res[1] = l;

        return res;
    }
}
