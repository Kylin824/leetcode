package org.example.hot100_v2.easy.tree;

import org.example.TreeNode;

/**
 * 二叉树的直径
 * @author kylin
 * @date 2026/6/30
 */
public class _543 {

    int maxDepth = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return maxDepth;
    }

    public int depth(TreeNode root) {
        if (root == null) return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        maxDepth = Math.max(maxDepth, left + right);
        return Math.max(left, right) + 1;
    }


}
