package org.example.leetcode.tree;

import org.example.leetcode.TreeNode;

public class SymmetricTree {
    /*
    101. 对称二叉树
     */

    public boolean qs(TreeNode root) {
        return isSame(root, root);
    }

    public boolean isSame(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) {
            return true;
        }
        if (r1 == null || r2 == null) {
            return false;
        }
        return r1.val == r2.val && isSame(r1.left, r2.right) && isSame(r1.right, r2.left);
    }
}
