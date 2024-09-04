package org.example.hot100.array;

//给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现
//次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
//
//
//
// 示例 1：
//
//
//输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2,2]
//
//
// 示例 2:
//
//
//输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[4,9]
//
//
//
// 提示：
//
//
// 1 <= nums1.length, nums2.length <= 1000
// 0 <= nums1[i], nums2[i] <= 1000
//
//
//
//
// 进阶：
//
//
// 如果给定的数组已经排好序呢？你将如何优化你的算法？
// 如果 nums1 的大小比 nums2 小，哪种方法更优？
// 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？

import scala.Int;

import java.util.*;

public class _350 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(_350.intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map1 = new HashMap<>();
        for (int i : nums1) {
            map1.merge(i, 1, Integer::sum);
        }
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i : nums2) {
            map2.merge(i, 1, Integer::sum);
        }

        List<Integer> res = new ArrayList<>();
        map1.forEach((k,v) -> {
            if (map2.get(k) != null) {
                for (int i = 0; i < Math.min(map2.get(k), v); i++) {
                    res.add(k);
                }
            }
        });

        return res.stream().mapToInt(i -> i).toArray();
    }

}
