package org.example.hot100_v2.medium;

/**
 * 寻找重复数
 * n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
 * @author kylin
 * @date 2026/7/7
 */

public class _287 {

    // 修改数组的方式
    public int findDuplicate1(int[] nums) {
        int tmp = 0;
        while (nums[0] != nums[nums[0]]) {
            tmp = nums[nums[0]];
            nums[nums[0]] = nums[0];
            nums[0] = tmp;
        }
        return nums[0];
    }

    // 不修改数组的方式
    public static int findDuplicate2(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int mid = i + (j - i) / 2;
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }
            if (count > mid) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicate2(new int[]{1,3,4,2,2})); // 2
        System.out.println(findDuplicate2(new int[]{3,1,3,4,2})); // 3
    }
}
