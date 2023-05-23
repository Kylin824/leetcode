package org.example.hot100.prefix_sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _1 {
    /*
    01 两数之和

    输入：nums = [2,7,11,15], target = 9
    输出：[0,1]

    输入：nums  = [3,2,4], target = 6
    输出：[1,2]

    输入：nums = [3,3], target = 6
    输出：[0,1]
     */

    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{3,2,4}, 6);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 时间 O(n)
     * 空间 O(n)
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{0, 0};
    }


}
