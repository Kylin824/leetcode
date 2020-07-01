package org.example.offer;

import java.util.Arrays;

public class ReOrderArray {
    /*
        NO.13
        调整数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
        并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     */
    /*
        思路:
            1. 辅助数组，遍历两次，一次奇数一次偶数
            2. 双指针, 从前往后将遇到的奇数插入到第一个偶数前面
     */
    public static void reOrderArray(int[] array) {
        int[] tmp = new int[array.length];
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) tmp[j++] = array[i];
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) tmp[j++] = array[i];
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = tmp[i];
        }
    }

    public static void reOrderArray1(int[] array) {
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            // 奇数插入到前面
            if (array[i] % 2 != 0) {
                int tmp = array[i];
                // 右移元素
                for (int k = i - 1; k >= j; k--) {
                    array[k+1] = array[k];
                }
                array[j] = tmp;
                j++;
            }
            // 偶数则跳过
        }
    }

    public static void main(String[] args) {
        int[] array = {1,3,4,5,6,8,9,0};
//        reOrderArray(array);
//        System.out.println(Arrays.toString(array));
        reOrderArray1(array);
        System.out.println(Arrays.toString(array));
    }
}
