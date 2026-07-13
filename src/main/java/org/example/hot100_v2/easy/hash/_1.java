package org.example.hot100_v2.easy.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * @author kylin
 * @date 2026/6/25
 */
public class _1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int n1 = nums[i];
            Integer n2 = map.get(target - n1);
            map.put(n1, i);
            if (n2 != null && n2 != i) {
                return new int[]{n2, i};
            }
        }
        return new int[]{};
    }
}
