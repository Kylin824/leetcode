package org.example.leetcode.tree;

import org.example.leetcode.TreeNode;

public class IsSameTree {
    /*
        100.判断两个二叉树是否相等
     */
    public boolean isSameTree (TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null || p.val != q.val)
            return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean qs(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        return p.val == q.val && qs(p.left, q.left) && qs(p.right, q.right);
    }
}
