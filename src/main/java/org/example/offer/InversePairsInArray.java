package org.example.offer;


import java.util.LinkedList;

public class InversePairsInArray {
    /*
        NO.35
        在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
        输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出 P%1000000007
        例如 1,2,3,4,5,6,7,0
        输出 7
     */
    /*
        思路:
            1. 暴力 nxn遍历 超时

            2. 利用归并排序，合并的时候计算逆序数 [3,4,5] [0, 1,2]
            如果3>0, 那么4、5也>0，可以直接加上3后面的所有数得到0前面的逆序数

     */
    private static int ret = 0;
    private static final int KMOD = 1000000007;

    public static int InversePairs(int [] array) {
        mergeSort(array, 0, array.length - 1);
        return ret;
    }

    public static void mergeSort(int[] array, int left, int right) {
        if (left >= right)
            return;
        int mid = left + (right - left) / 2;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    public static void merge(int[] array, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (array[i] >= array[j]) {
                tmp[k++] = array[j++];
                ret = ret + (mid - i + 1); // 与归并排序的唯一区别: 如果arr[i]>arr[j] 那么arr[i]后面的数都大于arr[j],直接加上
                ret = ret % KMOD;
            }
            else {
                tmp[k++] = array[i++];
            }
        }
        while (i <= mid)
            tmp[k++] = array[i++];
        while (j <= right)
            tmp[k++] = array[j++];
        for (k = 0, i = left; i <= right; i++, k++) {
            array[i] = tmp[k];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,0};
        System.out.println(InversePairs(arr));
//        mergeSort(arr, 0 , arr.length - 1);

    }
}
