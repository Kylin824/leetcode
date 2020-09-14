package org.example.leetcode.array;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
    /*
    求两数组的交集
    */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int n : nums1) {
            set1.add(n);
        }

        Set<Integer> set2 = new HashSet<>();
        for (int n : nums2) {
            set2.add(n);
        }

        set1.retainAll(set2);

        int[] res = new int[set1.size()];
        int i = 0;
        for (int n : set1) {
            res[i++] = n;
        }
        return res;
    }
}
