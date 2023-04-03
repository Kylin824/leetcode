package org.example.structure.template;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {

        int[] arr = {9, 5, 2, 3, 7, 1, 6, 8, 4, 0};

        heapSort3(arr);

        System.out.println(Arrays.toString(arr));

    }

    public static void heapSort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapAdjust(arr, i, arr.length);  // 建堆
        }
        int tmp;
        for (int i = arr.length - 1; i >= 0; i--) {
            tmp = arr[i];
            arr[i] = arr[0]; // 取走堆顶最大值
            arr[0] = tmp;

            heapAdjust(arr, 0, i);
        }
    }

    public static void heapAdjust(int[] heap, int i, int n) {
        int tmp;
        for (int j = 2 * i + 1; j < n; j = 2 * j + 1) {
            if (j + 1 < n && heap[j] < heap[j + 1]) {
                j++;
            }
            if (heap[i] < heap[j]) {
                tmp = heap[i];
                heap[i] = heap[j];
                heap[j] = tmp;
                i = j;
            } else
                break;
        }
    }

    public static void heapSort1(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapAdjust1(arr, i, arr.length);
        }
        int tmp;
        for (int i = arr.length - 1; i >= 0; i--) {
            tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;

            heapAdjust1(arr, 0, i);
        }
    }

    public static void heapAdjust1(int[] heap, int i, int n) {
        for (int j = 2 * i + 1; j < n; j = j * 2 + 1) {
            if (j + 1 < n && heap[j] < heap[j + 1]) {
                j++;
            }
            if (heap[i] < heap[j]) {
                int tmp = heap[i];
                heap[i] = heap[j];
                heap[j] = tmp;

                i = j;
            } else
                break;
        }
    }

    public static void heapSort2(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapAdjust2(arr, i, arr.length);
        }

        int tmp;
        for (int i = arr.length - 1; i >= 0; i--) {
            tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            heapAdjust2(arr, 0, i);
        }
    }

    public static void heapAdjust2(int[] heap, int i, int n) {
        int tmp;
        for (int j = 2 * i + 1; j < n; j = 2 * j + 1) {
            if (j + 1 < n && heap[j] < heap[j + 1]) {
                j++;
            }
            if (heap[i] < heap[j]) {
                tmp = heap[i];
                heap[i] = heap[j];
                heap[j] = tmp;

                i = j;
            } else
                break;
        }
    }

    public static void heapSort3(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapAdjust3(arr, i, arr.length);
        }
        int tmp = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            heapAdjust3(arr, 0, i);
        }
    }

    public static void heapAdjust3(int[] heap, int i, int n) {
        for (int j = 2 * i + 1; j < n; j = 2 * j + 1) {
            if (j + 1 < n && heap[j] < heap[j + 1]) {
                j++;
            }
            if (heap[i] < heap[j]) {
                int tmp = heap[i];
                heap[i] = heap[j];
                heap[j] = tmp;

                i = j;
            } else
                break;
        }
    }

    public static void heapSort4(int[] arr) {
        // 建堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapAdjust4(arr, i, arr.length);
        }
        int tmp = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            // 堆顶交换到尾部
            tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            // 调整0~n-1
            heapAdjust4(arr, 0, i);
        }
    }

    public static void heapAdjust4(int[] heap, int i, int n) {
        for (int j = 2 * i + 1; j < n; j = 2 * j + 1) {
            if (j + 1 < n && heap[j] < heap[j + 1]) { // 大根堆
                j++;
            }
            if (heap[i] < heap[j]) {
                int tmp = heap[i];
                heap[i] = heap[j];
                heap[j] = tmp;

                i = j;
            }
            else
                break;
        }
    }
}
