package org.example.offer.dp;

import java.util.Arrays;

public class MaxSumOfSubArray {
    /*
        NO.30
        求最大连续子数组的和
        例如{6,-3,-2,7,-15,1,2,2},最大连续子数组和为8(从第0个开始,到第3个为止)
     */
    /*
        思路:
            1. 动态规划
            状态定义: dp[i]表示以i结尾的连续子数组的最大和，最后返回dp[n-1]
            状态转移: dp[i] = Max(array[i], dp[i-1]+array[i])
            解释: 如果当前元素为整数，并且dp[i-1]为负数，那么dp[i]结果就是只选当前元素

            2. n*n遍历，计算所有子串大小

            3. 对下标为i的元素array[i]，先试探的加上array[i], 如果和为负数，显然，以i结尾的元素对整个结果不作贡献。
     */

    public int FindGreatestSumOfSubArray1(int[] array) {
        int[] dp = new int[array.length];
        dp[0] = array[0];
        int ret = array[0];
        for (int i = 1; i < array.length; i++) {
            dp[i] = Math.max(array[i], array[i] + dp[i-1]);
            ret = Math.max(dp[i], ret);
        }
        return ret;
    }


    public int FindGreatestSumOfSubArray2(int[] array) {
        int max = -1;
        for (int i = 0; i < array.length; i++) {
            int sum = 0;
            for (int j = i; j < array.length; j++) {
                sum += array[j];
                if (sum > max)
                    max = sum;
            }
        }
        return max;
    }

    public int FindGreatestSumOfSubArray3(int[] array) {
        int ret = array[0];
        int tmp = 0;
        for (int i : array) {
            if (tmp + i < 0)
                tmp = 0;
            else
                tmp += i;
            ret = Math.max(ret, tmp);
        }
        if (tmp != 0)
            return ret;
        // tmp为0说明都是负数，选最大的负数输出
        return Arrays.stream(array).max().getAsInt();
    }
}
