package org.example.structure.tree;

public class RecursiveTraverse {

    public void preOrderTraverse(TreeNode root) {
        if (root == null)
            return;
        System.out.print(root.val + " ");
        preOrderTraverse(root.left);
        preOrderTraverse(root.right);
    }

    public void inOrderTraverse(TreeNode root) {
        if (root == null)
            return;
        inOrderTraverse(root.left);
        System.out.print(root.val + " ");
        inOrderTraverse(root.right);
    }

    public void postOrderTraverse(TreeNode root) {
        if (root == null)
            return;
        postOrderTraverse(root.left);
        postOrderTraverse(root.right);
        System.out.print(root.val + " ");
    }
}
