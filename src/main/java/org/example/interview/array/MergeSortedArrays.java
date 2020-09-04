package org.example.interview.array;

public class MergeSortedArrays {
    /*
    面试题 10.01. 合并排序的数组
    给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
    初始化 A 和 B 的元素数量分别为 m 和 n。

    说明:
    A.length == n + m
     */
    public void merge(int[] A, int m, int[] B, int n) {
        int ia = m-1;
        int ib = n-1;
        int i = A.length - 1;
        while (ia >= 0 && ib >= 0) {
            A[i--] = A[ia] > B[ib] ? A[ia--] : B[ib--];
        }
        while (ib >= 0) {
            A[i--] = B[ib--];
        }
    }
}
