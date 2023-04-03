package org.example.structure.tree;

import org.example.leetcode.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class MinDepth {
    /*
    111. 二叉树的最小深度

    层序遍历，遇见第一个叶子节点为止
     */
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                if (cur.left == null && cur.right == null) {
                    return level;
                }
                size--;
            }
            level++;
        }
        return level;
    }
}
