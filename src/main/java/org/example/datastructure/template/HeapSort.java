package org.example.datastructure.template;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {

        int[] arr = {9, 5, 2, 3, 7, 1, 6, 8, 4, 0};

        heapSort(arr);

        System.out.println(Arrays.toString(arr));

    }

    public static void heapSort(int[] arr) {

        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapAdjust(arr, i, arr.length);  // 建堆
        }

        int tmp = 0;

        for (int i = arr.length - 1; i >= 0; i--) {
            tmp = arr[i];
            arr[i] = arr[0]; // 取走堆顶最大值
            arr[0] = tmp;

            heapAdjust(arr, 0, i);
        }
    }

    public static void heapAdjust(int[] heap, int i, int n) {
        int tmp = 0;
        for (int j = 2 * i + 1; j < n; j = 2 * j + 1) {
            if (j + 1 < n && heap[j] < heap[j + 1]) {
                j++;
            }
            if (heap[i] < heap[j]) {
                tmp = heap[i];
                heap[i] = heap[j];
                heap[j] = tmp;
                i = j;
            }
            else
                break;
        }
    }

}
