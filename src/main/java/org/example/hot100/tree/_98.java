package org.example.hot100.tree;

import org.example.TreeNode;

public class _98 {

    /**
     * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
     *
     */

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return false;
        }
        return inOrder(root.left, -1, (long)Integer.MIN_VALUE - 1, root.val)
                && inOrder(root.right, 1, root.val, (long)Integer.MAX_VALUE + 1);
    }

    public boolean inOrder(TreeNode root, int direct, long gt, long lt) {
        if (root == null) {
            return true;
        }
        // 左
        if (direct < 0 && !(gt < root.val && root.val < lt)) {
            return false;
        }
        // 右
        if (direct > 0 && !(gt < root.val && root.val < lt)) {
            return false;
        }
        return inOrder(root.left, -1, gt, root.val) && inOrder(root.right, 1, root.val, lt);
    }
}
