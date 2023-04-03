package org.example.leetcode.hot100;

import java.util.Arrays;

public class _31 {

    /**
     * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
     * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
     * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
     * 给你一个整数数组 nums ，找出 nums 的下一个排列。
     *
     *
     * 比如 nums = [1,2,7,4,3,1]，下一个排列是什么？
     *
     * 我们找到第一个最大索引是 nums[1] = 2
     *
     * 再找到第二个最大索引是 nums[4] = 3
     *
     * 交换，nums = [1,3,7,4,2,1];
     *
     * 翻转，nums = [1,3,1,2,4,7]
     * @param args
     */

    public static void main(String[] args) {

    }


    // 两重循环
    public static void nextPermutation(int[] nums) {

        if (nums == null || nums.length == 0) return;

        int firstIndex = -1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                firstIndex = i;
                break;
            }
        }

        // 说明整个数组是倒序的，直接翻转整个数组
        if (firstIndex == -1) {
            Arrays.sort(nums);
            return;
        }

        // 说明找到2所在位置

        int secondIndex = -1;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[firstIndex] < nums[i]) {
                secondIndex = i;
                break;
            }
        }

        // 找到3所在位置并交换值
        int tmp = nums[firstIndex];
        nums[firstIndex] = nums[secondIndex];
        nums[secondIndex] = tmp;

        // firstIndex后面的值翻转

        int i = firstIndex + 1;
        int j = nums.length - 1;
        while (i < j) {

            int swap = nums[i];
            nums[i] = nums[j];
            nums[j] = swap;

            i++;
            j--;
        }



    }
}
