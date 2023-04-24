package org.example.hot100.tree;

import org.example.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _114 {

    // 二叉树按前序遍历展开为链表

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        _114 o = new _114();
        o.flatten(root);

        while (root != null) {
            System.out.print(root.val + "");
            root = root.right;
        }
    }

    // 前序遍历后一一修改
    public void flatten(TreeNode root) {

        if (root == null) {
            return;
        }

        List<TreeNode> list = new ArrayList<>();

        preOrder(root, list);

        for (int i = 1; i < list.size(); i++) {
            TreeNode pre = list.get(i - 1);
            pre.left = null;
            pre.right = list.get(i);
        }

    }

    public void preOrder(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        list.add(root);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }

    // 进阶：前序遍历同时修改

    public void flatten1(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (pre != null) {
                pre.left = null;
                pre.right = cur;
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

    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return list;
    }
}
