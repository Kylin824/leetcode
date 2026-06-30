package org.example.hot100_v2;

import org.example.TreeNode;

/**
 * 合并两个二叉树
 * @author kylin
 * @date 2026/6/30
 */
public class _617 {

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return null;
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        TreeNode left = mergeTrees(root1.left, root2.left);
        TreeNode right = mergeTrees(root1.right, root2.right);
        TreeNode root = new TreeNode(root1.val + root2.val);
        root.left = left;
        root.right = right;
        return root;
    }

    public static void main(String[] args) {

        // root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(5);

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);
        root2.left.right = new TreeNode(4);
        root2.right.right = new TreeNode(7);

        TreeNode root = mergeTrees(root1, root2);
        System.out.println(root.val);
    }

}
