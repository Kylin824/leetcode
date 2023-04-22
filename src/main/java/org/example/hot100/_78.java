package org.example.hot100;

import java.util.ArrayList;
import java.util.List;

public class _78 {

    /**
     * 给你一个整数数组nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
     *
     * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
     *
     * 示例 1：
     *
     * 输入：nums = [1,2,3]
     * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     */

    public static void main(String[] args) {
        _78 o = new _78();
        List<List<Integer>> subsets = o.subsets(new int[]{1, 2, 3});
        System.out.println(subsets);
    }

    // 巧妙 自解！
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int size = res.size();

            for (int j = 0; j < size; j++) {
                List<Integer> tmpList = new ArrayList<>(res.get(j));
                tmpList.add(nums[i]);
                res.add(tmpList);
            }
        }
        return res;
    }

    // 回溯


}
