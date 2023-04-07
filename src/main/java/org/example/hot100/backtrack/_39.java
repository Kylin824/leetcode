package org.example.hot100.backtrack;

import java.util.*;

/**
 * @author kylin
 * @date 2023/4/7
 */
public class _39 {

    /**
     * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，
     * 找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，
     * 并以列表形式返回。你可以按 任意顺序 返回这些组合。
     */

    public static void main(String[] args) {
        _39 obj = new _39();
//        System.out.println(obj.combinationSum(new int[]{2, 3, 5}, 8));
//        System.out.println(obj.combinationSum(new int[]{2, 3, 6, 7}, 7));
//        System.out.println(obj.combinationSum(new int[]{2}, 1));
        System.out.println(obj.combinationSum(new int[]{8,7,4,3}, 11));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 0) {
            return res;
        }
        Stack<Integer> path = new Stack<>();
        Arrays.sort(candidates);
        dfs(res, path, 0, target, candidates, 0);
        return res;
    }

    public void dfs(List<List<Integer>> res, Stack<Integer> path, int sum, int target, int[] candidates, int begin) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            if (sum + candidates[i] > target) {
                break;
            }
            path.push(candidates[i]);
            dfs(res, path, sum + candidates[i], target, candidates, i);
            path.pop();
        }
    }
}
