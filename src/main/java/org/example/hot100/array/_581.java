package org.example.hot100.array;

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
//        System.out.println(findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15})); // 5
//        System.out.println(findUnsortedSubarray(new int[]{1, 2, 3, 4})); // 0
//        System.out.println(findUnsortedSubarray(new int[]{3, 2, 1})); // 3
//        System.out.println(findUnsortedSubarray(new int[]{2, 1})); // 2
//        System.out.println(findUnsortedSubarray(new int[]{1, 3, 2, 2, 2})); // 4
//        System.out.println(findUnsortedSubarray(new int[]{1, 2, 3, 3, 3})); // 0
        System.out.println(findUnsortedSubarray(new int[]{2, 3, 3, 2, 4})); // 3
    }

    public static int findUnsortedSubarray(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        if (nums.length == 2) {
            return nums[0] <= nums[1] ? 0 : 2;
        }
    }
}
