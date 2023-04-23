package org.example.hot100.tree;

public class _96 {

    /**
     * 不同的二叉搜索树
     * <p>
     * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种
     */

    public static void main(String[] args) {
        _96 o = new _96();

        System.out.println(o.numTrees1(1)); // 14
        System.out.println(o.numTrees1(4)); // 14
        System.out.println(o.numTrees1(5)); // 42

//        System.out.println(o.num(2, 5));
    }

    public int numTrees(int n) {
        return num(1, n);
    }

    // 递归
    public int num(int start, int end) {
        if (start >= end) {
            return 1;
        }
        if (start + 1 == end) {
            return 2;
        }
        if (start + 2 == end) {
            return 5;
        }
        int count = 0;
        for (int i = start; i <= end; i++) {
            int c = num(start, i - 1) * num(i + 1, end);
            count += c;
        }

        return count;
    }

    // dp
    public int numTrees1(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 5;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;

        for (int i = 4; i <= n; i++) {
            int j = 0;
            while (j < i) {
                dp[i] += dp[i - j - 1] * dp[j];
                j++;
            }
        }
        return dp[n];
    }

}
