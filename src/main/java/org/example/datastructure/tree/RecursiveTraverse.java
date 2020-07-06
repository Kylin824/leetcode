package org.example.datastructure.tree;

public class RecursiveTraverse {

    public void PreOrderTraverse(TreeNode root) {
        if (root == null)
            return;
        System.out.print(root.val + " ");
        PreOrderTraverse(root.left);
        PreOrderTraverse(root.right);
    }

    public void InOrderTraverse(TreeNode root) {
        if (root == null)
            return;
        PreOrderTraverse(root.left);
        System.out.print(root.val + " ");
        PreOrderTraverse(root.right);
    }

    public void PostOrderTraverse(TreeNode root) {
        if (root == null)
            return;
        PreOrderTraverse(root.left);
        PreOrderTraverse(root.right);
        System.out.print(root.val + " ");
    }
}
