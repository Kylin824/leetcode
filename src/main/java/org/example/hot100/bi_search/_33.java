package org.example.hot100.bi_search;

public class _33 {

    /**
     * 搜索旋转排序数组（数组中的值 互不相同）
     * <p>
     * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
     * <p>
     * 示例 1：
     * 输入：nums = [4,5,6,7,0,1,2], target = 0
     * 输出：4
     * <p>
     * 示例2：
     * 输入：nums = [4,5,6,7,0,1,2], target = 3
     * 输出：-1
     * <p>
     * 示例 3：
     * 输入：nums = [1], target = 0
     * 输出：-1
     */

    public static void main(String[] args) {
        _33 o = new _33();
        System.out.println(o.search(new int[]{4,5,6,7,0,1,2}, 3)); // -1
        System.out.println(o.search(new int[]{1,3}, 0)); // -1
        System.out.println(o.search(new int[]{1,3}, 3)); // 1
        System.out.println(o.search(new int[]{4,5,6,7,8,1,2,3}, 8)); // 4
        System.out.println(o.search(new int[]{1,2,3,4,5,6}, 4)); // 3
    }

    // 二分查找 管解
    public int search(int[] nums, int target) {

        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int res = -1;

        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 左边递增
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            // 右边递增
            else {
                if (nums[mid] < target && target <= nums[nums.length - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return res;
    }
}
