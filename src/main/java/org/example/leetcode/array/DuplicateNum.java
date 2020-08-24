package org.example.leetcode.array;

public class DuplicateNum {
    /*
    找出数组中重复的数字。
    在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
    数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
    请找出数组中任意一个重复的数字。

    利用0~n-1的特点

    输入：
    [2, 3, 1, 0, 2, 5, 3]
    输出：2 或 3
     */

    public static int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i && nums[i] == nums[nums[i]]) {
                return nums[i];
            }
            else if(nums[i] != i && nums[i] != nums[nums[i]]){
                int tmp = nums[i];
                nums[i] = nums[nums[i]];
                nums[tmp] = tmp;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 11, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        System.out.println(findRepeatNumber(arr));
    }
}
