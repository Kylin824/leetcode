package org.example.hot100_v2.medium.tree;

import org.example.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树中第 K 小的元素
 * @author kylin
 * @date 2026/7/18
 */

public class _230 {

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res, k);
        return res.get(k - 1);
    }

    public void dfs(TreeNode root, List<Integer> res, int k) {
        if (root == null || res.size() == k) return;
        dfs(root.left, res, k);
        res.add(root.val);
        dfs(root.right, res, k);
    }
}
