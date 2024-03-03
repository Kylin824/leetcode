package org.example.offer.tree;

import org.example.TreeNode;

public class LowestCommonAncestor {
    /*
        NO.68 二叉搜索树的最近公共祖先
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q); // 后序
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null) // 都为空说明树中没有该节点
            return null;
        if (left == null)
            return right;
        if (right == null)
            return left;
        return root;

    }

    public static void main(String[] args) {
        /*
                         5
                       /  \
                      8    6
                     / \  / \
                    9  2 1   0
                      / \
                     4  7
        */
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(9);
        TreeNode p = root.left.left; // 9
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(0);
        TreeNode q = root.right.right; // 0

        TreeNode commonAncestor = lowestCommonAncestor(root, p, q);
        System.out.println(commonAncestor.val);
    }
}
