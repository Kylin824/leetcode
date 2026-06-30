package org.example.hot100_v2.easy;

import org.example.TreeNode;

/**
 * 翻转二叉树
 *
 * @author kylin
 * @date 2026/6/30
 */
public class _226 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.right = left;
        root.left = right;
        return root;
    }

}
