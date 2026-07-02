package org.example.hot100_v2.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 数组元素的全部子集组合
 * @author kylin
 * @date 2026/7/2
 */
public class _78 {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int index = 0;
        backTrack(nums, res, index, path);
        return res;
    }

    public static void backTrack(int[] nums, List<List<Integer>> res, int index, List<Integer> path) {
        res.add(new ArrayList<>(path));

        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            backTrack(nums, res, i + 1, path);
            path.remove(path.size() - 1);
        }

    }

    public static void main(String[] args) {
        List<List<Integer>> subsets = subsets(new int[]{1, 2, 3}); // [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]
        System.out.println(subsets);
    }

}
