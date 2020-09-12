package org.example.leetcode.backtrack;

import scala.Int;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
    /*
        47. 全排列 II
        给定一个可包含重复数字的序列，返回所有不重复的全排列。

        示例:

        输入: [1,1,2]
        输出:
        [
          [1,1,2],
          [1,2,1],
          [2,1,1]
        ]

        全排列的基础上增加剪枝

     */

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0)
            return res;

        Arrays.sort(nums);

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
            if (used[i])
                continue;
             // i还没搜索过
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue; // 剪枝
            }
            path.add(nums[i]);
            used[i] = true;
            dfs(nums, len, depth + 1, path, used, res);
            used[i] = false;
            path.remove(path.size() - 1);

        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 3, 0, 3};
        PermutationsII solution = new PermutationsII();
        List<List<Integer>> lists = solution.permuteUnique(nums);
        System.out.println(lists);
    }
}
