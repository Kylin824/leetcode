package org.example.leetcode.tree;

import org.example.leetcode.TreeNode;

public class IsBalance {
    /*
    110. 平衡二叉树
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        return Math.abs(treeDepth(root.left) - treeDepth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int treeDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(treeDepth(root.left), treeDepth(root.right)) + 1;
    }
}
