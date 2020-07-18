package org.example.offer.tree;

import org.example.offer.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class TreeDepth {
    /*
        NO.38
        输入一棵二叉树，求该树的深度。
        从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
     */
    /*
        思路:
            1. 前序递归遍历
            2. 层序遍历
     */

    public static int treeDepthPreOrder(TreeNode root) {
            if (root == null)
                return 0;
            return Math.max(treeDepthPreOrder(root.left), treeDepthPreOrder(root.right)) + 1;
    }

    public static int TreeDepthLevelOrder(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (queue.size() > 0) {
            int sum = queue.size(); // sum记录这一层的节点数
            while (sum > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                sum--;
            }
            depth += 1;
        }
        return depth;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(8);
        root1.left = new TreeNode(8);
        root1.left.left = new TreeNode(9);
        root1.left.right = new TreeNode(2);
        root1.left.right.left = new TreeNode(4);
        root1.left.right.right = new TreeNode(7);
        root1.right = new TreeNode(7);
        System.out.println(treeDepthPreOrder(root1));
    }
}
