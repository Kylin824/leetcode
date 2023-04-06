package org.example.offer.tree;

import org.example.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MirrorTree {
    /*
        NO.18
        操作给定的二叉树，将其变换为源二叉树的镜像。
     */
    /*
        思路:
            交换每个节点的左右指针
            1. 递归版（后序遍历）
            2. 非递归版，采用层序遍历记录和修改每个节点的左右指针
     */
    public void Mirror(TreeNode root) {
        if (root == null)
            return;
        Mirror(root.left);
        Mirror(root.right);
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }

    public void Mirror1(TreeNode root) {
        if (root == null)
            return;
        // 层序遍历
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                TreeNode node = q.poll();
                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);

                TreeNode tmp = node.left;
                node.left = node.right;
                node.right = tmp;
                size--;
            }
        }
    }

}
