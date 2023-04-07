package org.example.hot100.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kylin
 * @date 2023/4/3
 */
public class _46 {

    // 全排列1：数组（无重复值）全排列

    public static void main(String[] args) {
        _46 obj = new _46();
        List<List<Integer>> permute = obj.permute(new int[]{1, 2, 3, 4});
        System.out.println(permute);
    }

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        if (nums.length == 0) {
            return res;
        }

        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        backtrack(res, path, nums, used);

        return res;
    }


    public void backtrack(List<List<Integer>> res, List<Integer> path, int[] nums, boolean[] used) {

        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
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
