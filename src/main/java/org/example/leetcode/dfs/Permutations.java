package org.example.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    /*
    46. 全排列
    给定一个 没有重复 数字的序列，返回其所有可能的全排列。

    示例:

    输入: [1,2,3]
    输出:
        [
          [1,2,3],
          [1,3,2],
          [2,1,3],
          [2,3,1],
          [3,1,2],
          [3,2,1]
        ]

    */

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0)
            return res;

        boolean[] used = new boolean[len];

        List<Integer> path = new ArrayList<>();

        dfs(nums, len, 0, path, used, res);

        return res;
    }

    public void dfs(int[] nums, int len, int depth, List<Integer> path, boolean[] used, List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;

                dfs(nums, len, depth + 1, path, used, res);

                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Permutations solution = new Permutations();
        List<List<Integer>> lists = solution.permute(nums);
        System.out.println(lists);
    }

}
