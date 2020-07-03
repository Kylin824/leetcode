package org.example.datastructure.sort;

public class MergeSort {
    /*
        思路: 不断递归划分为两个数组，当只有一个数时有序，进行合并
     */
    public static void mergeSort(int[] array, int left, int right) {
        // 只有一个数时不用划分
        if (left >= right)
            return;
        int mid = left + (right - left) / 2;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    public static void merge(int[] array, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1]; //
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (array[i] >= array[j])
                tmp[k++] = array[j++];
            else
                tmp[k++] = array[i++];
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
        int[] array = {8, 24, 31, 5, 7, 10, 47, 16, 72, 50, 21, 89};
        mergeSort(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

    }
}
