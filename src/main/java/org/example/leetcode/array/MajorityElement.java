package org.example.leetcode.array;

public class MajorityElement {
    /*
    169. 多数元素
    给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
    你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     */

    public int majorityElement(int[] nums) {
        int cur = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                cur = nums[i];
                count++;
            }
            else {
                if (cur == nums[i]) {
                    count++;
                }
                else {
                    count--; // 消去
                }
            }
        }
        count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (cur == nums[i]) {
                count++;
            }
        }
        if (count > nums.length / 2)
            return cur;
        return 0;

    }
}
