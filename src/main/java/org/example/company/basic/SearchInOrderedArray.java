package org.example.company.basic;

public class SearchInOrderedArray {
    /*
    请实现有重复数字的有序数组的二分查找。
    输出在数组中第一个大于等于查找值的位置，如果数组中不存在这样的数，则输出数组长度加一。

    示例1
    输入:  5,4,[1,2,4,4,5]   长度n为5 目标v为4
    输出:  3
    */
    public int search (int n, int v, int[] a) {
        if (n == 0 ||  a[n - 1] < v)
            return n + 1;
        if (v < a[0])
            return 1;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (a[mid] < v)
                left = mid + 1;
            else
                right = mid - 1;  // 二分的改版，等于的时候并不停下，而是继续往后找到第一个大于等于的
        }
        return left + 1;
    }
}
