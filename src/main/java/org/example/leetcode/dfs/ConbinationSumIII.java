package org.example.leetcode.dfs;

import scala.Int;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConbinationSumIII {
    /*
    216. 组合总和 III
    找出所有相加之和为 n 的 k个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。

    思路：
        dfs + 剪枝 + 回溯

    */
    public List<List<Integer>> combinationSum3(int k, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (k == 0)
            return res;
        ArrayList<Integer> path = new ArrayList<>();
        dfs(k, 1, target, path, res);
        return res;
    }

    public void dfs(int k, int begin, int target, ArrayList<Integer> path, List<List<Integer>> res) {
        if (target == 0 && k == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i <= 9; i++) {
            path.add(i);
            dfs(k - 1, i + 1, target - i, path, res);
            path.remove(path.size() - 1);
        }
    }

    public void dfs1(int k, int begin, int target, ArrayList<Integer> path, List<List<Integer>> res) {
        if (10 - k < begin) // 剪枝：找k个数，起点最多到10-k
            return;
        if (target == 0 && k == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i <= 9; i++) {
            if (target < i) // 剪枝
                break;
            path.add(i);
            dfs(k - 1, i + 1, target - i, path, res);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        ConbinationSumIII cs = new ConbinationSumIII();
        int k = 2;
        int n = 18;
        List<List<Integer>> res = cs.combinationSum3(k, n);
        for (List list : res) {
            for (Object i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

}
