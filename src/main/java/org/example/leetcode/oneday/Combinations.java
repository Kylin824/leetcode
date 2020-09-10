package org.example.leetcode.oneday;

import java.util.*;

public class Combinations {
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

//        for (int i = begin; i <= n; i++) {
        for (int i = begin; i <= n - (k - path.size()) + 1; i++) {  // 剪枝
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
