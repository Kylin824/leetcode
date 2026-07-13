package org.example.hot100_v2.easy.double_pointer;

import org.example.hot100_v2.easy.idea._326;

import java.util.Arrays;

/**
 * @author kylin
 * @date 2026/7/14
 */

public class _88 {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        if (m == 0) {
            for (int i = 0; i < nums2.length; i++) {
                nums1[i] = nums2[i];
            }
        }
        while (m > 0 && n > 0) {
            if (nums1[m - 1] > nums2[n - 1]) {
                nums1[m + n - 1] = nums1[m - 1];
                m--;
            } else {
                nums1[m + n - 1] = nums2[n - 1];
                n--;
            }
        }

        // n > 0 说明还有一些小的值在num2中，直接复制到num1的前n个元素中
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
        }
    }
    public static void main(String[] args) {
        _326 obj = new _326();

//        int[] nums1 = {1,2,3,0,0,0};
//        int m = 3;
//        int[] nums2 = {2,5,6};
//        int n = 3;
//        merge(nums1, m, nums2, n);

        int[] nums1 = {3,4,0,0};
        int m = 2;
        int[] nums2 = {1,2};
        int n = 2;
        merge(nums1, m, nums2, n);

        System.out.println(Arrays.toString(nums1));
    }
}
