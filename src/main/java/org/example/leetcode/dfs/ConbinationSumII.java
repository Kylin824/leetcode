package org.example.leetcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConbinationSumII {
    /*
    40. 组合总和 II
    给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
    candidates 中的每个数字在每个组合中只能使用一次。

    思路：
        dfs + 剪枝 + 回溯

    */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            if (target - candidates[i] < 0) // 剪枝：如果candidates[i] > target 那么i后面的也都 > target
                break;
            if (i > index && candidates[i] == candidates[i - 1]) // 剪枝：如果i跟i+1一样，则跳到i+1
                continue;

            path.add(candidates[i]);
            dfs(candidates, target - candidates[i], i + 1, path, res); // 从i再次dfs，因为元素可重复使用
            path.remove(path.size() - 1); // 回溯！
        }
    }

    public static void main(String[] args) {
        ConbinationSumII cs = new ConbinationSumII();
//        int[] candidates = {3,2,5};
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> res = cs.combinationSum2(candidates, target);
        for (List list : res) {
            for (Object i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

}
