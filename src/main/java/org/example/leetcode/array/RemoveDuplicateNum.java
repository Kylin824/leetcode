package org.example.leetcode.array;

public class RemoveDuplicateNum {
    /*
    26.
    给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

    不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     */

    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 0) return 0;
        int index = 0;
        int i = 0;
        int j = 1;
        while (j < nums.length) {

        }

        return index + 1;
    }

    public static void main(String[] args) {
//        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        int[] arr = {1,1,2,3};
        System.out.println(removeDuplicates(arr));
    }
}
