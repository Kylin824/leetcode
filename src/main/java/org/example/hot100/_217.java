package org.example.hot100;

import java.util.Arrays;

/**
 * @author kylin
 * @date 2024/3/1
 */
public class _217 {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length <= 1) {
            return false;
        }
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }
}
