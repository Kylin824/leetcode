package org.example.datastructure.template;

import java.util.Arrays;

public class O_nn_Sort {
    // 时间复杂度O(n^2)
    public static void main(String[] args) {
        int[] arr = {9, 25, 42, 33, 27, 51, 46, 38, 24, 10, 11, 13, 15, 21};

//        bubbleSort(arr);
        insertSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {  // 从后往前遍历 小的往前面冒泡
                    int tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                }
            }
        }
    }

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i; // 存最小值索引
            for (int j = i + 1; j < arr.length; j++) { // 从前往后遍历找最小值
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            }
            if (minIndex != i) {
                int tmp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = tmp;
            }
        }
    }

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {

            int tmp = arr[i]; // 暂存要插入的数据
            int j = i - 1; // 从前一个数开始查找

            while (j >= 0 && tmp < arr[j]) { // 边找边向后移动元素，腾出插入位置
                arr[j + 1] = arr[j];  // 大于tmp的数后移
                j--;
            }
            arr[j + 1] = tmp; //
        }
    }
}
