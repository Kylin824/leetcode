package org.example.datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class UnRecursiveTraverse {

    public void PreOrderTraverse(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode cur = stack.pop();
            System.out.print(cur.val + " ");
            if (cur.right != null)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);
        }
    }

    public void LevelOrderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() > 0) {
            TreeNode cur = queue.poll();
            // 记录每层的节点数量
            int levelSum = queue.size();
            while (levelSum-- > 0) {
                System.out.print(cur.val + " ");
                if (cur.left != null)
                    queue.offer(cur.left);
                if (cur.right != null)
                    queue.offer(cur.right);
            }
        }
    }
}
