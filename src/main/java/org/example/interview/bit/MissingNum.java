package org.example.interview.bit;

public class MissingNum {
    /*
    面试题 17.04. 消失的数字
    数组nums包含从0到n的所有整数，但其中缺了一个。请编写代码找出那个缺失的整数。你有办法在O(n)时间内完成吗？

    1. (1-n之和）- 数组和 = 缺少的数字

        1-n求和: n(1+n)/2

    2. 根据异或运算的特性去解题。res = res ^ x ^ x。
    */

    public static int missingNumberBit(int[] nums) {
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            num = num ^ i ^ nums[i];
        }
        num = num ^ nums.length;
        return num;
    }

    public static void main(String[] args) {
        int[] nums = {9,6,4,2,3,5,7,0,1};
        System.out.println(missingNumberBit(nums));
    }
}
