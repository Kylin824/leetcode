package org.example.leetcode.tree;

import org.example.offer.TreeNode;

public class DepthOfTree {
    /*
    104. 二叉树最大深度
     */

    public int qs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(qs(root.left), qs(root.right)) + 1;
    }
}
