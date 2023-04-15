package org.example.hot100.array;

import java.util.Arrays;

public class _169 {

    // 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。

    public static void main(String[] args) {
        _169 o = new _169();
        System.out.println(o.majorityElement1(new int[]{6, 5, 5}));
    }

    // 排序取中间的数
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    // 互相抵消
    public int majorityElement1(int[] nums) {
        int major = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                major = nums[i];
                count++;
            } else {
                if (nums[i] == major) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return major;
    }
}
