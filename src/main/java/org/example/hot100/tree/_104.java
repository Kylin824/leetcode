package org.example.hot100.tree;

import org.example.leetcode.TreeNode;

public class _104 {

    /**
     * 二叉树的最大深度  dfs
     */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(maxDepth(root));

    }

    public static int maxDepth(TreeNode root) {


        int maxDepth = 0;

        if (root == null) {
            return maxDepth;
        }

        int leftDepth = dfs(maxDepth, root.left);

        int rightDepth = dfs(maxDepth, root.right);

        return Math.max(leftDepth, rightDepth) + 1;

    }

    public static int dfs(int maxDepth, TreeNode node) {
        if (node == null) {
            return maxDepth;
        }
        // 叶子节点
        if (node.left == null && node.right == null) {
            return maxDepth + 1;
        }
        if (node.left != null && node.right != null) {
            return Math.max(dfs(maxDepth, node.left), dfs(maxDepth, node.right)) + 1;
        }
        if (node.left == null) {
            return Math.max(maxDepth, dfs(maxDepth, node.right)) + 1;
        }
        return Math.max(maxDepth, dfs(maxDepth, node.left)) + 1;
    }
}
