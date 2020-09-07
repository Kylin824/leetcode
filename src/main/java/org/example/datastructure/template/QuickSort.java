package org.example.datastructure.template;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {9, 5, 2, 3, 7, 1, 6, 8, 4, 0};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low >= high)
            return; // 递归终止条件
        int i = low;
        int j = high;
        int key = arr[low]; // 第一个数作为基准值

        while (i < j) {
            while (i < j && arr[j] >= key) { // 从右向左扫描找到第一个比基准值小的元素位置
                j--;
            }
            arr[i] = arr[j]; // 找到后放入
            while (i < j && arr[i] <= key) { // 从左到右扫描找到第一个比基准值大的元素位置
                i++;
            }
            arr[j] = arr[i];
        }

        arr[i] = key; //
        quickSort(arr, low, i - 1); // 递归调用
        quickSort(arr, i + 1, high);
    }
}
