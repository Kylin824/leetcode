package org.example.leetcode.array;

public class MergeTwoSortedArray {

    /*
        LC61 给出两个有序的整数数组A和B，请将数组B合并到数组A中，变成一个有序的数组,
            A数组有足够的空间存放B数组的元素，A和B中初始的元素数目分别为m和n
     */
    public void merge(int[] A, int m, int[] B, int n) {
        int ia = m - 1, ib = n - 1, icur = m + n - 1;
        while (ia >= 0 && ib >= 0) {
            A[icur--] = A[ia] >= B[ib] ? A[ia--] : B[ib--];
        }
        while (ib >= 0) {
            A[icur--] = B[ib--];
        }
    }
}
