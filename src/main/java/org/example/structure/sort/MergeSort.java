package org.example.structure.sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {9, 5, 2, 3, 7, 1, 6, 8, 4, 0};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int low, int high) {
        if (low >= high)
            return;
        int mid = low + (high - low) / 2;
        mergeSort(arr, low, mid);  // 左半部分 low到mid排好序
        mergeSort(arr, mid + 1, high); // 右半部分 mid+1到high排好序
        mergeArray(arr, low, mid, high); // 合并左右
    }

    public static void mergeArray(int[] arr, int low, int mid, int high) {
        // 合并两个数组， 左数组是arr[low]-arr[mid]  右数组是arr[mid+1]-arr[high]
        int[] tmp = new int[high - low + 1]; // 暂存合并后的数组
        int i = low; // 左数组指针
        int j = mid + 1; // 右数组指针
        int k = 0; // tmp数组
        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                tmp[k] = arr[i];  // 小的排前面
                k++;
                i++;
            }
            else {
                tmp[k] = arr[j];
                k++;
                j++;
            }
        }
        // 如果右边已加完(j > high)，把左边剩余的全加进去
        while (i <= mid) {
            tmp[k++] = arr[i++];
        }
        while (j <= high) {
            tmp[k++] = arr[j++];
        }

        // 排好序的tmp数组copy到arr数组
        for (k = 0, i = low; i <= high; i++, k++) {
            arr[i] = tmp[k];
        }
    }
}
