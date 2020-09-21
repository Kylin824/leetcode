package org.example.datastructure.template;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {9, 5, 2, 3, 7, 1, 6, 8, 4, 0};
        quickSort3(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low >= high)
            return; // 递归终止条件
        int i = low;
        int j = high;
        int tmp = arr[i]; // 第一个数作为基准值

        while (i < j) {
            while (i < j && arr[j] >= tmp) { // 从右向左扫描找到第一个比基准值小的元素位置
                j--;
            }
            arr[i] = arr[j]; // 找到后放入
            while (i < j && arr[i] <= tmp) { // 从左到右扫描找到第一个比基准值大的元素位置
                i++;
            }
            arr[j] = arr[i];
        }

        arr[i] = tmp; //
        quickSort(arr, low, i - 1); // 递归调用
        quickSort(arr, i + 1, high);
    }

    public static void quickSort1(int[] arr, int low, int high) {
        if (low >= high)
            return;
        int i = low, j = high, tmp = arr[low];
        while (i < j) {
            while (i < j && arr[j] >= tmp) {
                j--;
            }
            arr[i] = arr[j];
            while (i < j && arr[i] <= tmp) {
                i++;
            }
            arr[j] = arr[i];
        }
        arr[i] = tmp;
        quickSort1(arr, low, i - 1);
        quickSort1(arr, i + 1, high);
    }

    public static void quickSort2(int[] arr, int low, int high) {
        if (low >= high)
            return;
        int i = low, j = high, tmp = arr[i];
        while (i < j) {
            while (i < j && arr[j] >= tmp) {
                j--;
            }
            arr[i] = arr[j];
            while (i < j && arr[i] <= tmp) {
                i++;
            }
            arr[j] = arr[i];
        }
        arr[i] = tmp;
        quickSort2(arr, low, i - 1);
        quickSort2(arr, i + 1, high);
    }

    public static void quickSort3(int[] arr, int low, int high) {
        if (low >= high)
            return;
        int i = low, j = high, tmp = arr[low];
        while (i < j) {
            while (i < j && arr[j] > tmp) {
                j--;
            }
            arr[i] = arr[j];
            while (i < j && arr[i] < tmp) {
                i++;
            }
            arr[j] = arr[i];
        }
        arr[i] = tmp;
        quickSort3(arr, low, i - 1);
        quickSort3(arr, i + 1, high);
    }
}
