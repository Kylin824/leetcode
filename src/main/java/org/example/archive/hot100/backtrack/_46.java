package org.example.archive.hot100.backtrack;

import java.util.ArrayList;
import java.util.List;

//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//
//
// 示例 2：
//
//
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
//
//
// 示例 3：
//
//
//输入：nums = [1]
//输出：[[1]]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 6
// -10 <= nums[i] <= 10
// nums 中的所有整数 互不相同
//
//
// Related Topics 数组 回溯 👍 2824 👎 0

public class _46 {

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

    public static void main(String[] args) {
        _46 obj = new _46();
        List<List<Integer>> permute = obj.permute(new int[]{1, 2, 3, 4});
        System.out.println(permute);
    }
}
