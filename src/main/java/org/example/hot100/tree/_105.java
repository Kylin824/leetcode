package org.example.hot100.tree;

import org.example.TreeNode;

import java.util.Arrays;

public class _105 {


    /**
     * 105. 从前序与中序遍历序列构造二叉树
     * @param args
     */
    public static void main(String[] args) {
        _105 o = new _105();

        TreeNode root = o.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println(root);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int len = 0;
        while (len < inorder.length &&  inorder[len] != preorder[0]) {
            len++;
        }
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, len + 1), Arrays.copyOfRange(inorder, 0, len));
        root.right = buildTree(Arrays.copyOfRange(preorder, len + 1, preorder.length), Arrays.copyOfRange(inorder, len + 1, inorder.length));
        return root;
    }

}
