package org.example.hot100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _448 {

    public static void main(String[] args) {
        List<Integer> disappearedNumbers = findDisappearedNumbers2(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
        System.out.println(disappearedNumbers);
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length;) {
            if (nums[i] != i + 1) {
                if (nums[i] == nums[nums[i] - 1]) {
                    set.add(i + 1);
                    i++;
                }
                else {
                    set.remove(nums[i]);
                    swap(nums, i, nums[i] - 1);
                }
            } else {
                i++;
            }
        }
        return new ArrayList<>(set);
    }

    public static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }


    // 时间：2*O(n) = O(n)
    // 空间：n
    public static List<Integer> findDisappearedNumbers1(int[] nums) {
        List<Integer> res = new ArrayList<>();
        boolean[] flags = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            flags[nums[i] - 1] = true;
        }
        for (int i = 0; i < flags.length; i++) {
            if (!flags[i]) {
                res.add(i + 1);
            }
        }
        return res;
    }


    // https://leetcode.cn/problems/find-all-numbers-disappeared-in-an-array/comments/181697
    // 时间：2*O(n) = O(n)
    // 空间：O(1)
    public static List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1] > 0) {
                nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
