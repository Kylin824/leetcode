package org.example.leetcode.bit;

public class SingleNum {
    // 136. 只出现一次的数字

    public static int singleNumber(int[] nums) {
        int cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cur = nums[i] ^ cur;
        }
        return cur;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,3,2,4,5,5,4};
        System.out.println(singleNumber(nums));
    }
}
