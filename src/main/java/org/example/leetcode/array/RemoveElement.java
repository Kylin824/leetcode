package org.example.leetcode.array;

import java.util.Arrays;
import java.util.EnumMap;

public class RemoveElement {

    /*
        LC123 给定一个数组和一个值，使用就地算法将数组中所有等于这个值的元素删除，并返回新数组的长度。
     */
    public static int removeElement(int[] A, int elem) {
        int index = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != elem) {
                A[index++] = A[i];
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,7,7,8,8,9,9,9,9};

        System.out.println(removeElement(arr, 7));
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
