package org.example.leetcode;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        ArrayList<Integer> arrList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            int n = sc.nextInt();
            arrList.add(n);
        }

        int len = arrList.size();
        int max = 0;
        for (int i = 1; i < len - 1; i++) {
            if (arrList.get(i-1) < arrList.get(i+1)
                    && arrList.get(i) > arrList.get(i-1)
                    && arrList.get(i) > arrList.get(i+1)) {

                int del = arrList.remove(i);
                int tmp_max = getMaxLength(arrList);
                if (tmp_max > max) {
                    max = tmp_max;
                }
                arrList.add(i, del);
            }
        }
        System.out.println(max);
    }

    public static int getMaxLength(ArrayList<Integer> arrlist){
        int size = arrlist.size();
        int res = 1;
        int current = 1;
        for (int i = 1; i < size; i++) {
            if(arrlist.get(i) > arrlist.get(i - 1)) {
                current++;
            }
            else {
                if (current > res) {
                    res = current;
                }
                current = 1;
            }
        }
        return current > res ? current : res;
    }

    private static void quickSort(long[] array, int low, int high) {
        if (low < high) {
            int pivot = partition(array, low, high);
            quickSort(array, low, pivot - 1);
            quickSort(array, pivot + 1, high);
        }
    }

    private static int partition(long[] array, int low, int high) {
        int pivot = low;
        int index = pivot + 1;
        for (int i = index; i <= high; i++) {
            if (array[i] < array[pivot]) {
                swap(array, i, index);
                index++;
            }
        }
        swap(array, pivot, index - 1);
        return index - 1;
    }

    private static void swap(long[] arr, int i, int j) {
        long temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
