package org.example.leetcode.array;

import java.util.Arrays;

public class TwoSumII {
    /*
    167. 两数之和 II - 输入有序数组
    给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
     */
    public int[] twoSum(int[] numbers, int target) {
        int[] ret = {0, 0};
        for (int i = 0; i < numbers.length; i++) {
            ret[0] = i + 1;
            int index2 = Arrays.binarySearch(numbers, target - numbers[i]);
            if (index2 > 0) {
                if (index2 != i) {
                    ret[1] = index2 + 1;
                    return ret;
                }
                else {
                    ret[1] = index2 + 2;
                    return ret;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {

    }
}
