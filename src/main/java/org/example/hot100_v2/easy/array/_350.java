package org.example.hot100_v2.easy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 两个数组的交集II
 * @author kylin
 * @date 2026/7/18
 */

public class _350 {

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<Integer>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }
        return list.stream().mapToInt(x -> x).toArray();
    }

    public static void main(String[] args) {
        _350 solution = new _350();
        System.out.println(Arrays.toString(solution.intersect(new int[]{4,9,5}, new int[]{9,4,9,8,4})));
        System.out.println(Arrays.toString(solution.intersect(new int[]{1,2,2,1}, new int[]{2,2})));
    }

}
