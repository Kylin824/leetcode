package org.example.offer.tree;

import org.example.offer.TreeNode;

public class IsBalancedTree {
    /*
        NO.39
        输入一棵二叉树，判断该二叉树是否是平衡二叉树。
     */
    /*
        思路:
            递归前序求左右子树深度，如果左子树深度与右子树相差小于1则返回true
     */
    public static boolean isBalancedTree(TreeNode root) {
        if (root == null)
            return true;
        return Math.abs(treeDepth(root.left) - treeDepth(root.right)) <= 1;
    }

    public static int treeDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(treeDepth(root.left), treeDepth(root.right)) + 1;
    }
}
