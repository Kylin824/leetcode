package org.example.hot100.bi_search;

import java.util.Arrays;

public class _34 {

    /**
     * 在排序数组中查找元素的第一个和最后一个位置
     *
     * 示例 1：
     * 输入：nums = [5,7,7,8,8,10], target = 8
     * 输出：[3,4]
     *
     * 示例2：
     * 输入：nums = [5,7,7,8,8,10], target = 6
     * 输出：[-1,-1]
     *
     * 示例 3：
     * 输入：nums = [], target = 0
     * 输出：[-1,-1]
     *
     */

    public static void main(String[] args) {
        _34 o = new _34();
//        System.out.println(Arrays.toString(o.searchRange(new int[]{5,7,7,8,8,10}, 8)));
        System.out.println(Arrays.toString(o.searchRange(new int[]{2,2}, 1)));
    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};

        if (nums.length == 0) {
            return res;
        }

        int l = 0, r = nums.length - 1;

        // 找左边界
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] == target){
                r = mid;
            } else if (nums[mid] > target) {
                r = mid;
            }
        }
        // nums[r] 为 target 左边界 或为空
        if (nums[r] != target) {
            return res;
        }
        res[0] = r;

        l = 0;
        r = nums.length - 1;

        // 找右边界
        while (l < r) {
            int mid  = (l + r + 1) / 2;  // int mid  = (l + r) / 2 + 1; 效果相同
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] == target) {
                l = mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
            }
        }

        res[1] = l;

        return res;
    }
}
