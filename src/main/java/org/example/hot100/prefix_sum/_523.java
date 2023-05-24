package org.example.hot100.prefix_sum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kylin
 * @date 2023/5/23
 */
public class _523 {

    /**
     * 给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
     * <p>
     * 子数组大小 至少为 2 ，且
     * 子数组元素总和为 k 的倍数。
     * 如果存在，返回 true ；否则，返回 false 。
     * <p>
     * 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。0 始终视为 k 的一个倍数。
     */

    public static void main(String[] args) {
//        System.out.println(checkSubarraySum1(new int[]{23, 2, 4, 6, 7}, 6)); // t
//        System.out.println(checkSubarraySum1(new int[]{23, 2, 6, 4, 7}, 6)); // t
//        System.out.println(checkSubarraySum1(new int[]{23, 2, 6, 4, 7}, 13)); // f
//        System.out.println(checkSubarraySum1(new int[]{0, 0}, 1)); // t
//        System.out.println(checkSubarraySum1(new int[]{23, 6, 9}, 6)); // f

        System.out.println(checkSubarraySum2(new int[]{23, 2, 4, 6, 7}, 6)); // t
        System.out.println(checkSubarraySum2(new int[]{23, 2, 6, 4, 7}, 6)); // t
        System.out.println(checkSubarraySum2(new int[]{23, 2, 6, 4, 7}, 13)); // f
        System.out.println(checkSubarraySum2(new int[]{0, 0}, 1)); // t
        System.out.println(checkSubarraySum2(new int[]{23, 6, 9}, 6)); // f
    }

    public static boolean checkSubarraySum1(int[] nums, int k) {
        int[] prenums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prenums[i + 1] = prenums[i] + nums[i];
        }
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j < i - 1; j++) {
                if ((prenums[i] - prenums[j]) % k == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkSubarraySum2(int[] nums, int k) {
        // <presum, index>
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int presum = 0;
        for (int i = 0; i < nums.length; i++) {
            presum += nums[i];
            int key = k == 0 ? presum : presum % k;
            if (map.containsKey(key)) {
                if (i - map.get(key) >= 2) {
                    return true;
                }
                continue;
            }
            map.put(key, i);
        }
        return false;
    }
}
