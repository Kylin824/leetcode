package org.example.interview.bsearch;

import java.awt.image.Kernel;

public class MagicIndex {
    /*
    面试题 08.03. 魔术索引
    魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。
    给定一个有序整数数组（有重复值），编写一种方法找出魔术索引，若有的话，在数组A中找出一个魔术索引，如果没有，则返回-1。
    若有多个魔术索引，返回索引值最小的一个。

    1. 暴力从头到尾 O(n)
    2. 暴力优化 如果nums[i] > i+1 则 直接跳到nums[nums[i]]

    3. 二分查找
    */

    public int findMagicIndex1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i)
                return i;
        }
        return -1;
    }

    public int findMagicIndexOpt1(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i)
                return i;
            i = Math.max(nums[i], i + 1);
        }
        return -1;
    }

    public int findMagicIndexBSOpt(int[] nums) {
        return find(nums, 0, nums.length - 1);
    }

    public int find(int[] nums, int left, int right) {
        if (left > right)
            return -1;
        int mid = (right - left) / 2 + left;
        int leftIndex = find(nums, left, mid - 1);
        if (leftIndex != -1) { // 递归查找左边
            return leftIndex;
        }
        else if (nums[mid] == mid) { // 左边没有  判断中间
            return mid;
        }
        return find(nums, mid + 1, right); // 左边中间都没有  递归查找右边
    }
}

