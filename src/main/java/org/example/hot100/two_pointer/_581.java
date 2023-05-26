package org.example.hot100.two_pointer;

/**
 * @author kylin
 * @date 2023/5/25
 */
public class _581 {

    /**
     * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
     * <p>
     * 请你找出符合题意的 最短 子数组，并输出它的长度。
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [2,6,4,8,10,9,15]
     * 输出：5
     * 解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
     * 示例 2：
     * <p>
     * 输入：nums = [1,2,3,4]
     * 输出：0
     */

    public static void main(String[] args) {
        System.out.println(findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15})); // 5
        System.out.println(findUnsortedSubarray(new int[]{1, 2, 3, 4})); // 0
        System.out.println(findUnsortedSubarray(new int[]{3, 2, 1})); // 3
        System.out.println(findUnsortedSubarray(new int[]{2, 1})); // 2
        System.out.println(findUnsortedSubarray(new int[]{1, 3, 2, 2, 2})); // 4
        System.out.println(findUnsortedSubarray(new int[]{1, 2, 3, 3, 3})); // 0
        System.out.println(findUnsortedSubarray(new int[]{2, 3, 3, 2, 4})); // 3
    }

    // 双指针
    public static int findUnsortedSubarray(int[] nums) {
        int l = 0;
        while (l < nums.length - 1 && nums[l] <= nums[l + 1]) {
            l++;
        }
        if (l == nums.length - 1) {
             return 0;
        }
        int r = nums.length - 1;
        while (r > 0 && nums[r] >= nums[r - 1]) {
            r--;
        }
        if (r == 0) {
            return 0;
        }

        // 此时 0-l递增 l-r无序 r-n递增
        // 子数组的左边界必定在0-l之间，有边界必定在r-n之间
        for (int i = l + 1; i < nums.length; i++) {
            while (l >= 0 && nums[i] < nums[l]) {
                l--;
            }
        }
        for (int i = r - 1; i >= 0; i--) {
            while (r < nums.length && nums[i] > nums[r]) {
                r++;
            }
        }
        return r - l - 1;

    }
}
