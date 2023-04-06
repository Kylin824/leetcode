package org.example.interview.tree;

import org.example.TreeNode;

public class IsBalancedTree {
    /*
    面试题 04.04. 检查平衡性
    实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。

    递归
    左右子树高度差<=1 && 左子树平衡 && 右子树平衡
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int depth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}
