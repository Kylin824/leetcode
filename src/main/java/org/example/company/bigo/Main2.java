package org.example.company.bigo;

import java.util.*;

public class Main2 {

    public static void main(String[] args) {
//        Short[] arr = {9, 5, 2, 3, 7, 1, 6, 8, 4, 0};
        Character[] arr = {'9', '5', '2', '3', '7', '1', '6', '8', '4', '0'};
//        quickSort(arr, 0, arr.length - 1, Integer::compareTo);
        quickSort(arr, 0, arr.length - 1, Character::compareTo);
        System.out.println(Arrays.toString(arr));
    }

    public static <T> void quickSort(T[] arr, int low, int high, Comparator<T> comparator) {
        if (low >= high)
            return;
        int i = low;
        int j = high;
        T tmp = arr[low];

        while (i < j) {
            while (i < j && comparator.compare(arr[j], tmp) <= 0) {
                j--;
            }
            arr[i] = arr[j];
            while (i < j && comparator.compare(arr[i], tmp) >= 0) {
                i++;
            }
            arr[j] = arr[i];
        }

        arr[i] = tmp;
        quickSort(arr, low, i - 1, comparator);
        quickSort(arr, i + 1, high, comparator);
    }
}
