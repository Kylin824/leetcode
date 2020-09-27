package org.example.company.bigo;

import org.example.leetcode.TreeNode;

public class Two {
    /*
    二叉树变成单向链表，要求直接在原节点上调整节点指针得到。
    //             1
    //            / \
    //           2   5
    //          / \   \
    //         3   4   6
    //    1
    //     \
    //      2
    //       \
    //        3
    //         \
    //          4
    //           \
    //            5
    //             \
    //              6
     */
    public static TreeNode treeToList(TreeNode root) {
        if (root == null)
            return null;
        TreeNode left = root.left;
        if (left != null) {
            left = treeToList(left);
        }
        TreeNode right = root.right;
        root.right = left;
        if (right != null) {
            right = treeToList(right);
        }
        while (left != null && left.right != null) {
            left = left.right;
        }
        if (left != null) {
            left.right = right;
        }
        if (left == null) {
            root.right = right;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(5);
        head.left.left = new TreeNode(3);
        head.left.right = new TreeNode(4);
        head.right.right = new TreeNode(6);
        TreeNode res = treeToList(head);
        while (res!=null) {
            System.out.print(res.val + " ");
            res = res.right;
        }
    }
}
