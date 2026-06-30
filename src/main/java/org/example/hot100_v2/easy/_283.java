package org.example.hot100_v2.easy;

import java.util.Arrays;

/**
 * 移动数组中的0到末尾
 * @author kylin
 * @date 2026/6/30
 */
public class _283 {
    public static void moveZeroes(int[] nums) {
        int p = 0;
        while (p < nums.length) {
            if (nums[p] == 0) {
                int q = p + 1;
                while (q < nums.length) {
                    if (nums[q] != 0) {
                        // 交换位置
                        int tmp = nums[q];
                        nums[q] = nums[p];
                        nums[p] = tmp;
                        break;
                    } else {
                        q++;
                    }
                }
            }
            p++;
        }
        System.out.println(Arrays.asList(nums));
    }

    public static void main(String[] args) {
        moveZeroes(new int[]{0, 1, 0, 3, 12});
    }
}
