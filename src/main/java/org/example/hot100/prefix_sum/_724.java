package org.example.hot100.prefix_sum;

/**
 * @author kylin
 * @date 2023/5/23
 */
public class _724 {
    /**
     * 给你一个整数数组 nums ，请计算数组的 中心下标 。
     * <p>
     * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
     * <p>
     * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
     * <p>
     * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
     */

    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{1, 7, 3, 6, 5, 6})); // 3
        System.out.println(pivotIndex(new int[]{1, 2, 3})); // -1
        System.out.println(pivotIndex(new int[]{2, 1, -1})); // 0
    }

    public static int pivotIndex(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        int[] prenums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prenums[i + 1] = prenums[i] + nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (prenums[i] == prenums[prenums.length - 1] - prenums[i + 1]) {
                return i;
            }
        }
        return -1;
    }
}
