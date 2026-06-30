package org.example.hot100_v2.easy;

/**
 * 找出数组中占比超过1/2的数
 * @author kylin
 * @date 2026/6/30
 */
public class _169 {

    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }
}
