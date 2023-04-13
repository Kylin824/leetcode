package org.example.hot100.tree;

import javafx.print.Collation;
import org.example.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _101 {

    // 给一个二叉树的根节点 root ， 检查它是否轴对称。

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left == null || root.right == null) {
            return false;
        }

        return root.left.val == root.right.val && isSymmetric(root.left, root.right);

    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {

        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }

        return left.val == right.val && isSymmetric(left.right, right.left) && isSymmetric(left.left, right.right);
    }


    public static void main(String[] args) {
        _101 o = new _101();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);

        System.out.println(o.isSymmetric(root));
    }
}
