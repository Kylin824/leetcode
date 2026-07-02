package org.example.hot100_v2.medium.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 数组中元素组合等于目标值的case数
 *
 * @author kylin
 * @date 2026/7/2
 */
public class _39 {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();

        Stack<Integer> path = new Stack<>();

        int index = 0;
        Arrays.sort(candidates);
        backTrack(res, path, index, candidates, target);

        return res;

    }

    public static void backTrack(List<List<Integer>> res, Stack<Integer> path, int index, int[] candidates, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                path.push(candidates[i]);
                backTrack(res, path, i, candidates, target - candidates[i]);
                path.pop();
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res = combinationSum(new int[]{2, 3, 5, 6, 7}, 7);
        System.out.println(res);
    }
}
