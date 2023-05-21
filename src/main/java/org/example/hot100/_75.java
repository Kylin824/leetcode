package org.example.hot100;

import java.util.Arrays;

public class _75 {

    public static void main(String[] args) {
        _75 o = new _75();
//        int[] nums = new int[]{2,0,2,1,1,0};
//        int[] nums = new int[]{2,0,1};
        int[] nums = new int[]{1,2,0};
        o.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sortColors(int[] nums) {
        int zero = 0;
        int two = nums.length - 1;
        int i = 0;
        while (i <= two) {
            if (nums[i] == 0) {
                swap(nums, zero, i);
                zero++;
                i++;
            } else if (nums[i] == 2){
                swap(nums, two, i);
                two--;
            } else {
                i++;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
