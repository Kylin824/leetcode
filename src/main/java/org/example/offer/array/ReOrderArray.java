package org.example.offer.array;

import java.util.Arrays;

public class ReOrderArray {
    /*
        NO.13
        调整数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
        并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     */
    /*
        思路:
            双指针, 从前往后将遇到的奇数插入到第一个偶数前面（因为要保证插入原奇偶相对位置不变，所以插入后移方式）
     */

    public static void reOrderArray(int[] array) {
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                // 奇数插入到前面
                int tmp = array[i];
                // 右移元素
                for (int k = i - 1; k >= j; k--) {
                    array[k + 1] = array[k];
                }
                array[j] = tmp;
                j++;
            }
            // 偶数则跳过
        }
    }

    // 前后指针，会改变相对位置
    public static void reOrderArray1(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            // left指向第一个偶数
            while (left < right && nums[left] % 2 == 1) {
                left++;
            }
            while (left < right && nums[right] % 2 == 0) {
                right--;
            }
            if (left < right) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 4, 5, 6, 8, 9, 0};
//        reOrderArray(array);
//        System.out.println(Arrays.toString(array));
        reOrderArray(array);
        System.out.println(Arrays.toString(array));
    }
}
