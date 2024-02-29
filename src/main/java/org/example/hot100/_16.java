package org.example.hot100;


//给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
//
// 返回这三个数的和。
//
// 假定每组输入只存在恰好一个解。
//
//
//
// 示例 1：
//
//
//输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
//
//
// 示例 2：
//
//
//输入：nums = [0,0,0], target = 1
//输出：0
//
//
//
//
// 提示：
//
//
// 3 <= nums.length <= 1000
// -1000 <= nums[i] <= 1000
// -10⁴ <= target <= 10⁴
//
//
// Related Topics 数组 双指针 排序 👍 1588 👎 0

import java.util.Arrays;

public class _16 {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int i = 0, j = 1, k = 2;
        int res = nums[i] + nums[j] + nums[k];
        while (k < nums.length) {
            j = 1;
            while (j < k) {
                i = 0;
                while (i < j) {
                    int tmp = nums[i] + nums[j] + nums[k];
                    if (Math.abs(tmp - target) <= Math.abs(res - target)) {
                        res = tmp;
                    }
                    i++;
                }
                j++;
            }
            k++;
        }
        return res;
    }

    public static void main(String[] args) {
        _16 a = new _16();
        System.out.println(a.threeSumClosest(new int[]{-4, -1, 1, 2}, 1));
    }

}
