package org.example.hot100.tree;

import org.example.TreeNode;

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
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

//    public static int dfs(int maxDepth, TreeNode node) {
//        if (node == null) {
//            return 0;
//        }
//        // 叶子节点
//        if (node.left == null && node.right == null) {
//            return maxDepth + 1;
//        }
//        if (node.left != null && node.right != null) {
//            return Math.max(dfs(maxDepth, node.left), dfs(maxDepth, node.right)) + 1;
//        }
//        if (node.left == null) {
//            return Math.max(maxDepth, dfs(maxDepth, node.right)) + 1;
//        }
//        return Math.max(maxDepth, dfs(maxDepth, node.left)) + 1;
//    }
}
