package org.example.structure.sort;

import java.util.Arrays;

public class RadixSort {
    // 基数排序

    public static void main(String[] args) {

        int[] arr = {9, 5, 2, 3, 7, 1, 6, 8, 4, 0, 11, 13, 15, 21};

        radixSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int[] arr) {

        int max = arr[0]; // 待排序列最大值
        int exp; // 基数

        // 遍历一遍找到最大值
        for (int anArr : arr) {
            if (anArr > max) {
                max = anArr;
            }
        }

        //从个位((xxx / 1) % 10)开始，对数组进行排序
        for (exp = 1; max / exp > 0; exp *= 10) {

            int[] temp = new int[arr.length]; // 存储待排元素的临时数组

            int[] buckets = new int[10]; // 0~9分为10个桶。


            for (int num : arr) { //将数据对应位出现的次数存储在buckets中
                buckets[(num / exp) % 10]++;  // (num / exp) % 10 : num的最底位(个位)
            }

            // 更改buckets[i]中的索引位置
            for (int i = 1; i < 10; i++) {
                buckets[i] += buckets[i - 1];
            }

            //将数据从桶中取出，存放到临时数组temp中
            for (int i = arr.length - 1; i >= 0; i--) {
                temp[buckets[(arr[i] / exp) % 10] - 1] = arr[i];
                buckets[(arr[i] / exp) % 10]--;
            }

            //将有序元素temp赋给arr
            System.arraycopy(temp, 0, arr, 0, arr.length);
        }
    }
}
