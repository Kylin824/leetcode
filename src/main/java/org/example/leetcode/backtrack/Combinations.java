package org.example.leetcode.backtrack;

import java.util.*;

public class Combinations {
    /*
        77. 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

        示例:
        输入: n = 5, k = 3
        输出:
            [
              [1, 2, 3],
              [1, 2, 4],
              [1, 2, 5],
              [1, 3, 4],
              [1, 3, 5],
              [1, 4, 5],
              [2, 3, 4],
              [2, 3, 5],
              [2, 4, 5],
              [3, 4, 5]
            ]
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();

        if (k == 0 || n < k)
            return res;

        Deque<Integer> path  = new ArrayDeque<>();
        dfs(n, k, 1, path, res);
        return res;
    }

    public void dfs(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        // for (int i = begin; i <= n; i++) { // 无剪枝 21ms
        for (int i = begin; i <= n - (k - path.size()) + 1; i++) {  // 剪枝 2ms
            path.addLast(i);
            System.out.println("递归之前 => " + path);
            dfs(n, k, i + 1, path, res);
            path.removeLast();
            System.out.println("递归之后 => " + path);
        }

    }

    public static void main(String[] args) {
        Combinations c = new Combinations();
        List<List<Integer>> res = c.combine(5, 3);
        System.out.println(res);
    }
}
