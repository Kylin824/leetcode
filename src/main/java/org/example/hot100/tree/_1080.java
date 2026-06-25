package org.example.hot100.tree;

import org.example.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author kylin
 * @date 2023/5/22
 */
public class _1080 {


    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(-5);
        root.right.left = new TreeNode(4);
        TreeNode res = sufficientSubset(root, -1);
        System.out.println(levelOrder(res));
    }

    public static TreeNode sufficientSubset(TreeNode root, int limit) {
        if (root == null) {
            return null;
        }
        // 叶子节点
        if (root.left == null && root.right == null) {
            if (root.val < limit) {
                return null;
            } else {
                return root;
            }
        }
        int l = Integer.MIN_VALUE, r = Integer.MIN_VALUE;
        if (root.left != null) {
            l = root.left.val;
        }
        if (root.right != null) {
            r = root.right.val;
        }
        root.left = sufficientSubset(root.left, limit - root.val);
        root.right = sufficientSubset(root.right, limit - root.val);
        if (root.left == null && root.right == null && Math.max(root.val + l, root.val + r) < limit) {
            return null;
        }
        return root;
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            while (size > 0) {
                TreeNode node = queue.poll();
                size--;
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(level);
        }
        return res;
    }
}
