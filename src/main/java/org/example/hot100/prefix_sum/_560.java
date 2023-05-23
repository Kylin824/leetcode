package org.example.hot100.prefix_sum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kylin
 * @date 2023/5/23
 */
public class _560 {

    /**
     * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。
     */

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(subarraySum(new int[]{1, 2, 3}, 3));
        System.out.println(subarraySum(new int[]{-1, -1, 1}, 0));

        System.out.println(subarraySum2(new int[]{1, 1, 1}, 2));
        System.out.println(subarraySum2(new int[]{1, 2, 3}, 3));
        System.out.println(subarraySum2(new int[]{-1, -1, 1}, 0));
    }

    // 二重循环 暴力
    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    // 前缀和 暴力
    public static int subarraySum1(int[] nums, int k) {
        int[] prenums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            // 从1开始填充
            prenums[i + 1] = prenums[i] + nums[i];
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                // num[i] + num[i+1] + ... + num[j] = prenum[j] - prenum[i]
                sum = prenums[j + 1] - prenums[i];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    // 前缀和 + hashmap
    public static int subarraySum2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        int presum = 0;
        for (int num : nums) {
            presum += num;
            if (map.containsKey(presum - k)) {
                count += map.get(presum - k);
            }
            map.put(presum, map.getOrDefault(presum, 0) + 1);
        }
        return count;
    }
}
