package org.example.hot100.array;

public class _152 {

    // 乘积最大子数组
    // 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。


    public static void main(String[] args) {
        _152 o = new _152();

        o.maxProduct(new int[]{2, 3, -2, -4, 5, 2});

    }

    // dp
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int imax = 1, imin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax * nums[i],  nums[i]);
            imin = Math.min(imin * nums[i],  nums[i]);
            max = Math.max(imax, max);
        }
        return max;
    }
}
