package org.example.leetcode.tree;

import org.example.leetcode.TreeNode;

public class SymmetricTree {
    /*
    101. 判断对称二叉树
    */

    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) {
            return true;
        }
        if (r1 == null || r2 == null || r1.val != r2.val) {
            return false;
        }
        return check(r1.left, r2.right) && check(r1.right, r2.left);
    }
}
