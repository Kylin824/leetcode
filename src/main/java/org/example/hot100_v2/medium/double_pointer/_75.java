package org.example.hot100_v2.medium.double_pointer;

import java.util.Arrays;

/**
 * @author kylin
 * @date 2026/7/10
 */

public class _75 {

    public static int[] sortColors(int[] nums) {
        int zero = 0;
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            if (nums[i] == 2) {
                swap(nums, i, j);
                j--;
            } else if (nums[i] == 0) {
                swap(nums, i, zero);
                zero++;
                i = zero;
            } else if (nums[i] == 1) {
                if (nums[i] == nums[zero]) {
                    i++;
                } else {
                    swap(nums, i, zero);
                }
            }
        }
        return nums;
    }
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(sortColors(new int[]{2,0,2,1,1,0})));
        System.out.println(Arrays.toString(sortColors(new int[]{2,0,1})));
    }

}
