package org.example.hot100.backtrack;

import org.apache.spark.sql.sources.In;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kylin
 * @date 2023/4/7
 */
public class _47 {

    // 全排列2：数组（有重复值）全排列+去重

    // 回溯 + 剪枝

    public static void main(String[] args) {
        List<List<Integer>> lists = permuteUnique(new int[]{2, 1, 1, 1});
        System.out.println(lists);
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtrack(res, new ArrayList<>(), nums, used);

        return res;
    }

    public static void backtrack(List<List<Integer>> res, List<Integer> path, int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                backtrack(res, path, nums, used);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
