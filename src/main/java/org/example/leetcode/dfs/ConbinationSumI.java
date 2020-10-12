package org.example.leetcode.dfs;

import java.util.*;

public class ConbinationSumI {
    /*
    39. 组合总和
    给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
    candidates 中的数字可以无限制重复被选取。

    思路：
        dfs + 剪枝 + 回溯

    */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 0)
            return res;
        Arrays.sort(candidates);
        ArrayList<Integer> path = new ArrayList<>();
        dfs(candidates, target, 0, path, res);
        return res;
    }

    public void dfs(int[] candidates, int target, int index, ArrayList<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (target - candidates[i] < 0) // 剪枝
                break;
            path.add(candidates[i]);
            dfs(candidates, target - candidates[i], i, path, res); // 从i再次dfs，因为元素可重复使用
            path.remove(path.size() - 1); // 回溯！
        }
    }

    public static void main(String[] args) {
        ConbinationSumI cs = new ConbinationSumI();
        int[] candidates = {3,2,5};
        int target = 8;
        List<List<Integer>> res = cs.combinationSum(candidates, target);
        for (List list : res) {
            for (Object i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

}
