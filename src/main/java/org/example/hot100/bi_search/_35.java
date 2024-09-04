package org.example.hot100.bi_search;

public class _35 {

    public static void main(String[] args) {
//        System.out.println(searchInsert(new int[]{1,3,5,6}, 7));
//        System.out.println(searchInsert(new int[]{1,3,5,6}, 2));
        System.out.println(searchInsert(new int[]{1,3}, 1));
    }

    public static int searchInsert(int[] nums, int target) {
        int i = 0, j = nums.length - 1, mid = 0;
        if (nums[0] >= target) {
            return 0;
        }
        if (nums[nums.length - 1] < target) {
            return nums.length;
        }
        if (nums[nums.length - 1] == target) {
            return nums.length - 1;
        }
        while (i <= j) {
            mid = (i + j) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return nums[mid] < target ? mid + 1 : mid;
    }
}
