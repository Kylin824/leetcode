package org.example.hot100.tree;

import org.example.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _94 {

    // 二叉树中序遍历

    /**
     * ps
     * 前序遍历：打印 - 左 - 右
     * 中序遍历：左 - 打印 - 右
     * 后序遍历：左 - 右 - 打印
     */

    public static void main(String[] args) {
        _94 obj =  new _94();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> res = obj.inorderTraversal1(root);
        System.out.println(res);

    }

    // 递归
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        inorder(res, root);
        return res;
    }

    public void inorder(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(res, root.left);
        res.add(root.val);
        inorder(res, root.right);
    }

    // 迭代 利用栈
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root != null) {
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }

}
