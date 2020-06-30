package org.example.offer;

public class Utils {

    /**
     * 递归先序遍历二叉树
     * @param root 根节点
     */
    public static void PreOrderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        PreOrderTraverse(root.left);
        PreOrderTraverse(root.right);
    }

}
