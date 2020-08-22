package org.example.leetcode.array;

import java.util.Arrays;

public class TwoSumII {
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
