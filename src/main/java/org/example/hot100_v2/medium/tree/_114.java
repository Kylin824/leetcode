package org.example.hot100_v2.medium.tree;

import org.example.TreeNode;

import java.util.Stack;

/**
 * @author kylin
 * @date 2026/7/3
 */

public class _114 {

    public static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode pre = null;
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (pre != null) {
                pre.right = cur;
                pre.left = null;
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
            pre = cur;
        }
    }

    public static void main(String[] args) {
        //输入：root = [1,2,5,3,4,null,6]
        //输出：[1,null,2,null,3,null,4,null,5,null,6]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        flatten(root);
        TreeNode.print(root);
    }
}
