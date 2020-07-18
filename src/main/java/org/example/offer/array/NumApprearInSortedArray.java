package org.example.offer.array;

import java.util.Arrays;

public class NumApprearInSortedArray {
    /*
        NO.37
        统计给定的一个数字在排序数组中出现的次数。
     */
    /*
        思路:
            1. 二分查找
            2. api: Arrays.binarySearch(int[] arr, int k)
     */

    public static int GetNumberOfK(int[] array , int k) {
        if (array.length <= 0)
            return 0;
        if (k < array[0] || k > array[array.length - 1])
            return 0;

        // k在数组中，二分查找k
        int left = 0;
        int right = array.length - 1;
        int mid = 0;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (array[mid] < k) {
                left = mid + 1;
            } else if (array[mid] > k){
                right = mid - 1;
            } else
                break;
        }

        // k不存在于数组中
        if (array[mid] != k)
            return 0;

        // 找到k所在位置mid
        left = mid;
        right = mid;
        int count = 0;
        while (left >= 0 && array[left] == k) {
            count++;
            left--;
        }
        while (right <= array.length - 1 && array[right] == k) {
            count++;
            right++;
        }
        return count - 1;
    }

    public static int GetNumberOfK1(int[] array , int k) {

        if (array.length <= 0)
            return 0;
        if (k < array[0] || k > array[array.length - 1])
            return 0;

        int index = Arrays.binarySearch(array, k);
        if (index < 0)
            // k不存在
            return 0;
        // 找到k所在位置mid
        int left = index;
        int right = index;
        int count = 0;
        while (left >= 0 && array[left] == k) {
            count++;
            left--;
        }
        while (right <= array.length - 1 && array[right] == k) {
            count++;
            right++;
        }
        return count - 1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,3,3,3};
        System.out.println(GetNumberOfK(arr, 3));
    }
}
