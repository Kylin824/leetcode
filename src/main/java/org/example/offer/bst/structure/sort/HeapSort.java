package org.example.offer.bst.structure.sort;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {9, 5, 2, 3, 7, 1, 6, 8, 4, 0};
        heapSort(arr);
    }

    public static void heapSort(int[] arr) {

        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapAdjust(arr, i, arr.length);  // 从第n/2-1个节点开始调整堆，得到大根堆
        }

        int tmp = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            tmp = arr[i];
            arr[i] = arr[0]; // 取走堆顶最大值放到最后
            arr[0] = tmp;

            heapAdjust(arr, 0, i); // 再次调整堆
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void heapAdjust(int[] heap, int i, int n) {
        int tmp = 0;
        for (int j = 2 * i + 1; j < n; j = 2 * j + 1) {
            if (j + 1 < n && heap[j] < heap[j + 1]) { // 比较左右孩子节点，j指向大的那个
                j++;
            }
            if (heap[i] < heap[j]) { // 大的节点与根节点比较，大于根节点则交换值

                tmp = heap[i];
                heap[i] = heap[j];
                heap[j] = tmp;

                i = j; // 根节点下移到原来大的孩子节点位置，向下继续调整
            }
            else
                break;
        }
    }

}
