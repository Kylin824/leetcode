package org.example.interview.array;

public class MoreThanHalf {
    /*
    面试题 17.10. 主要元素
    数组中占比超过一半的元素称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。

    两两消去
    */
    public int majorityElement(int[] nums) {
        int cur = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                cur = nums[i];
                count++;
            }
            else {
                if (cur == nums[i])
                    count++;
                else
                    count--;
            }
        }
        count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == cur)
                count++;
        }
        return count > nums.length / 2 ? cur : -1;
    }
}
