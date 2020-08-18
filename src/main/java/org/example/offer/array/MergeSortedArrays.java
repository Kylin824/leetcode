package org.example.offer.array;

import java.util.Arrays;

public class MergeSortedArrays {
    /*
    88. 合并两个有序数组
    给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
    说明:
    初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
    你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。

    示例
    输入:
    nums1 = [1,2,3,0,0,0], m = 3
    nums2 = [2,5,6],       n = 3

    输出: [1,2,2,3,5,6]

    输入[0] 0 [1] 1
    输出
     */

    public static void qs(int[] nums1, int m, int[] nums2, int n) {
        int end = nums1.length - 1;
        int i = m - 1;
        int j = n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[end] = nums1[i];
                i--;
                end--;
            }
            else {
                nums1[end] = nums2[j];
                j--;
                end--;
            }
        }
        while (j >= 0) {
            nums1[end] = nums2[j];
            j--;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] n1 = {1,2,3,0,0,0};
        int[] n2 = {2,5,6};
        qs(n1, 3, n2, 3);
        System.out.println(Arrays.toString(n1));
    }
}
