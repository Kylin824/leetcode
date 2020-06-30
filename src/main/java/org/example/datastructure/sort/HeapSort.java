package org.example.datastructure.sort;

public class HeapSort {
    public static void main(String[] args) {
        int[] array = {8, 24, 31, 5, 7, 10, 88, 47, 16, 72, 50};

        HeapSort hs = new HeapSort();

        hs.heapSort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

    }
    
    public void heapSort(int[] array) {
        // 调整大根堆
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            heapAdjust(array, i, array.length);
        }
        
        // 交换第一个数与最后一个数，并调整大根堆
        for (int j = array.length - 1; j >= 0; j--) {
            // swap
            swap(array, 0 , j);
            // adjust
            heapAdjust(array, 0, j);
        }
    }
    
    private void heapAdjust(int[] array, int s, int m) {
        // 默认[s...m]中的关键字除了s之外均满足大根堆的定义
        // 根节点
        int val = array[s];

        for (int j = 2 * s + 1; j < m; j = 2 * j + 1) {

            // 左右子节点大小比较 j指向大的子节点
            if (j + 1 < m && array[j] < array[j+1]) j++;

            // 根节点与大的节点比较
            if (val > array[j]) {
                break;
            }

            // 根小则交换根
            else {
                array[s] = array[j];
                s = j;
            }
        }
        array[s] = val;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
