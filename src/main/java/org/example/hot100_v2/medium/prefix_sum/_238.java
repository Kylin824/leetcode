package org.example.hot100_v2.medium.prefix_sum;

import java.util.Arrays;

/**
 *
 * 数组的乘积
 *
 * 不能用除法和两次循环
 *
 * @author kylin
 * @date 2026/7/2
 *
 * 前缀和、前缀积
 */

public class _238 {

    public static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = prefix;
            prefix = prefix * nums[i]; // 每个数左边的乘积
        }
        int suffix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] = res[i] * suffix; // 乘上右边的乘积
            suffix = suffix * nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1,2,3,4})));
    }

}
