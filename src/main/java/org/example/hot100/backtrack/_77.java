package org.example.hot100.backtrack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author kylin
 * @date 2023/4/7
 */
public class _77 {

    // 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。

    public static void main(String[] args) {
        _77 obj = new _77();
        List<List<Integer>> combine = obj.combine(4, 2);
        System.out.println(combine);
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n < k) {
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        dfs(res, path, 1, n, k);
        return res;
    }

    public void dfs(List<List<Integer>> res, Deque<Integer> path, int begin, int n, int k) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i <= n; i++) {
            path.addLast(i);
            dfs(res, path, i + 1, n, k);
            path.removeLast();
        }
    }
}
