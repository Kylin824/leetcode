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
     *
     * 子数组大小 至少为 2 ，且
     * 子数组元素总和为 k 的倍数。
     * 如果存在，返回 true ；否则，返回 false 。
     *
     * 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。0 始终视为 k 的一个倍数。
     */

    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length == 0) {
            return false;
        }
        int[] prenums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prenums[i + 1] = prenums[i] + nums[i];
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i - 1; j++) {
                if ((prenums[i] - prenums[j]) % k == 0) {

                }
            }
        }
    }
}
