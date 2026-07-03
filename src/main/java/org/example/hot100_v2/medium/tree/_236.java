package org.example.hot100_v2.medium.tree;

import org.example.TreeNode;

/**
 * 二叉树的最近公共祖先
 * @author kylin
 * @date 2026/7/3
 */
public class _236 {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode commonLeft = lowestCommonAncestor(root.left, p, q);
        TreeNode commonRight = lowestCommonAncestor(root.right, p, q);
        if (commonLeft == null) {
            return commonRight;
        }
        if (commonRight == null) {
            return commonLeft;
        }
        return root;
    }

    public static void main(String[] args) {

    }
}
