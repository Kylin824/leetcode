package org.example.hot100.prefix_sum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kylin
 * @date 2023/5/23
 */
public class _930 {

    /**
     * 同_560
     * 给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。
     */

    public static void main(String[] args) {
        System.out.println(numSubarraysWithSum(new int[]{1, 0, 1, 0, 1}, 2));
        System.out.println(numSubarraysWithSum(new int[]{0, 0, 0, 0, 0}, 0));
    }

    public static int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        int presum = 0;
        for (int num : nums) {
            presum += num;
            if (map.containsKey(presum - goal)) {
                count += map.get(presum - goal);
            }
            map.put(presum, map.getOrDefault(presum, 0) + 1);
        }
        return count;
    }

}
