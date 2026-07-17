package org.example.hot100_v2.easy.array;

/**
 *
 * 删除有序数组中的重复项
 * @author kylin
 * @date 2026/7/18
 */

public class _26 {

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int i = 0, j = 1, count = 1;
        while (j < nums.length) {
            if (nums[j] != nums[i]) {
                nums[i + 1] = nums[j];
                i++;
                count++;
            }
            j++;
        }
        return count;
    }

    public static void main(String[] args) {
        _26 obj = new _26();
        System.out.println(obj.removeDuplicates(new int[]{1}));
        System.out.println(obj.removeDuplicates(new int[]{1,1}));
        System.out.println(obj.removeDuplicates(new int[]{1,1,2,3,3,4}));
        System.out.println(obj.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }
}
