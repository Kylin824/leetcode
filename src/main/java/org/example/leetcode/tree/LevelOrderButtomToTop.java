package org.example.leetcode.tree;

import org.example.leetcode.TreeNode;

import java.util.*;

public class LevelOrderButtomToTop {
    /*
    107. 二叉树自底向上层序遍历
     */

    public static List<List<Integer>> qs(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode cur;
        while (!queue.isEmpty()) {
            int levelSum = queue.size();
            List<Integer> level = new ArrayList<>();
            while (levelSum > 0) {
                cur = queue.poll();
                level.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                levelSum--;
            }
            ret.add(level);
        }
        Collections.reverse(ret);
        return ret;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(17);

        List<List<Integer>> ret = qs(root1);
        System.out.println("test");
    }
}
