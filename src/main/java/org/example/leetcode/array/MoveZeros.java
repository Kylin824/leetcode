package org.example.leetcode.array;

import java.util.Arrays;

public class MoveZeros {
    /*
    283. 原地移动零到数组末尾
    示例:
    输入: [0,1,0,3,12]
    输出: [1,3,12,0,0]
     */

    public static void moveZeros(int[] nums) {
        int i = 0, j = 0;
        while (i < nums.length) {
            // 第一个0
            while (i < nums.length && nums[i] != 0) {
                i++;
            }
            j = i + 1;
            // 第一个非0
            while (j < nums.length && nums[j] == 0) {
                j++;
            }
            if (j >= nums.length) {
                return;
            }
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
        }
    }


    public static void main(String[] args) {
//        int[] arr = {0,1,0,3,12};
//        int[] arr = {0};
        int[] arr = {1};
        moveZeros(arr);
        System.out.println(Arrays.toString(arr));
    }
}
