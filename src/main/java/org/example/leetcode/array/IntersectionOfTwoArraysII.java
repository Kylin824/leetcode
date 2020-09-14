package org.example.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IntersectionOfTwoArraysII {
    /*
    350. 两个数组的交集 II
    给定两个数组，编写一个函数来计算它们的交集。
    输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
    我们可以不考虑输出结果的顺序。
    */
    public static int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int k = 0;
        for (int i : nums2) {
            if (map.getOrDefault(i, 0) > 0) {
                map.put(i, map.get(i) - 1);
                nums2[k] = i;
                k++;
            }
        }
        return Arrays.copyOf(nums2, k);
    }

    public static void main(String[] args) {
        int[] num1 = {1,2,2,1};
        int[] num2 = {2,2};
        intersection(num1, num2);
    }
}
