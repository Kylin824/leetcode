package org.example.hot100.tree;

import org.example.TreeNode;

public class _226 {

    /*
    给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。

            2                 2
          /   \             /  \
         1     3           3    1

     */

    public static void main(String[] args) {

        _226 o = new _226();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        o.invertTree(root);

        System.out.println(root);
    }

    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);

        return root;

    }
}
