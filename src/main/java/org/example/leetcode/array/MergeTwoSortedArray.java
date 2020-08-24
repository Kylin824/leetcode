package org.example.leetcode.array;

public class MergeTwoSortedArray {

    /*
    给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
    初始化 A 和 B 的元素数量分别为 m 和 n。

    输入:
    A = [1,2,3,0,0,0], m = 3
    B = [2,5,6],       n = 3
    输出: [1,2,2,3,5,6]

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

    // 从最后一个位置开始填入A、B中大的元素
    public void mergeTwoSortedArrays(int[] A, int m, int[] B, int n) {
        int ia = m - 1, ib = n - 1, icur = m + n - 1;
        while (ia >= 0 && ib >= 0) {
            A[icur--] = A[ia] > B[ib] ? A[ia--] : B[ib--];
        }
        while (ib >= 0) {
            A[icur--] = B[ib--];
        }
    }
}
