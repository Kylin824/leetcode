package org.example.hot100.idea;

import java.util.Arrays;

public class _287 {

    // 给定一个包含n + 1 个整数的数组nums ，其数字都在[1, n]范围内（包括 1 和 n），可知至少存在一个重复的整数。
    //
    //假设 nums 只有 一个重复的整数 ，返回这个重复的数 。
    //
    //你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
    //

    public static void main(String[] args) {
        _287 o = new _287();
        System.out.println(o.findDuplicate3(new int[]{8,7,1,10,17,15,18,11,16,9,19,12,5,14,3,4,2,13,18,18}));;
    }

    // 修改数组的方式
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }
        return 0;
    }

    public int findDuplicate1(int[] nums) {
        int tmp = 0;
        while (nums[0] != nums[nums[0]]) {
            tmp = nums[0];
            nums[0] = nums[tmp];
            nums[tmp] = tmp;
        }
        return nums[0];
    }

    // 不修改数组的方式


    // 二重循环 超时
    public int findDuplicate2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (j == i) {
                    continue;
                }
                if (nums[j] == nums[i]) {
                    return nums[i];
                }
            }
        }
        return 0;
    }

    // 二重循环优化 二分查找
    public int findDuplicate3(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            int count = 0;  // 数组中小于等于mid的数量   如果count > mid 说明 在左半部分， 否则说明在右半部分
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }
            if (count > mid) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }


}
