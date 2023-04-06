package org.example.leetcode.tree;

import org.example.TreeNode;

public class DepthOfTree {
    /*
    104. 二叉树最大深度
     */

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}
