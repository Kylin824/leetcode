package org.example.hot100_v2.easy;

import org.example.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的高度
 * @author kylin
 * @date 2026/6/29
 */
public class _104 {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        // 后序遍历、DFS
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            depth += 1;
        }
        return depth;
    }

}
