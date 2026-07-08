package org.example.structure.template;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {9, 5, 2, 3, 7, 1, 6, 8, 4, 0};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void heapSort(int[] arr) {
        int n = arr.length;
        // 建堆，从最后一个非叶子节点的位置( n / 2 - 1)开始
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapAdjust(arr, i, n);
        }
        for (int i = n - 1; i >= 0; i--) {
            swap(arr, 0, i); // 取走堆顶最大值放到数组最后
            heapAdjust(arr, 0, i); // 重新调整前面的堆
        }
    }

    public static void heapAdjust(int[] arr, int i, int n) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
        // 左节点大于当前节点
        if (left < n && arr[left] > arr[i]) {
            largest = left;
        }
        // 右节点大于当前节点
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        // 子节点提到根节点位置，从子节点重新调整
        if (largest != i) {
            swap(arr, largest, i);
            heapAdjust(arr, largest, n);
        }
    }
}
