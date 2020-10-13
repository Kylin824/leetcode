package org.example.median;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15ThreeSum {
    /*
    15. 三数之和
    给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
    使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。

    注意：答案中不可以包含重复的三元组。
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3)
            return res;
        Arrays.sort(nums);
        int l, r, target;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            l = i + 1;
            r = nums.length - 1;
            while (l < r) {
                if (nums[i] + nums[l] + nums[r] == 0) {
                    ArrayList<Integer> tuple = new ArrayList<>();
                    tuple.add(nums[i]);
                    tuple.add(nums[l]);
                    tuple.add(nums[r]);
                    res.add(tuple);
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (r > l && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (nums[i] + nums[l] + nums[r] < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0};
        List<List<Integer>> res = threeSum(nums);
        System.out.println("test");
    }
}
