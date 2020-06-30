package org.example.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Arrays {

    // #1-E 两数之和
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] indexs = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.get(target - nums[i]) != null) {
                indexs[0] = map.get(target - nums[i]);;
                indexs[1] = i;
                return indexs;
            }
            else{
                map.put(nums[i], i);
            }
        }
        return indexs;
    }

    // #26-E 删除已排序数组中的重复项
    public static int removeDuplicates(int[] nums) {

        // 判空
        if (nums.length <= 0) return 0;

        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[index] != nums[i]) {
                index++;
                nums[index] = nums[i];
            }
        }
        return index + 1;
    }

    // #80-M 删除已排序数组中的重复项 ii
    public static int removeDuplicatesII(int[] nums) {
        int index = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[index - 2])
                nums[index++] = nums[i];
        }
        return index;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{1, 2, 3, 6, 7, 8};
//        int target = 8;
//        int[] res = twoSum(nums, target);
//        for (int re : res) {
//            System.out.println(re);
//        }

        int[] nums = new int[]{1,1,1,2,2,3,3,3,3,3,4,4,5,5,5};
//        int len = removeDuplicates(nums);
//        System.out.println(len);
        int lenii = removeDuplicatesII(nums);
        System.out.println(lenii);
    }
}
