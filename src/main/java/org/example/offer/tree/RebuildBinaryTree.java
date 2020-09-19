package org.example.offer.tree;

import org.example.offer.TreeNode;

import java.util.Arrays;

public class RebuildBinaryTree {
    /*
        NO.4
        输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
        eg:前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
     */
    /*
        思路: 递归，分别重建左右子树
        tips: Arrays.copyOfRange()
     */
    public static TreeNode reConstructBinaryTree(int [] preOrderArr, int [] inOrderArr) {

        TreeNode root = new TreeNode(preOrderArr[0]);
        // 只有一个节点
        if (preOrderArr.length == 1 && inOrderArr.length == 1) {
            root.left = null;
            root.right = null;
            return root;
        }

        int mid = 0; // 寻找根节点在中序序列中的位置，将中序序列分为左右两边

        while (inOrderArr[mid] != preOrderArr[0])
            mid++;

        if (mid > 0) {
            // 当前节点有左子树，递归重建左子树
            int[] leftPre = Arrays.copyOfRange(preOrderArr, 1, mid + 1);
            int[] leftIn = Arrays.copyOfRange(inOrderArr, 0, mid);
            root.left = reConstructBinaryTree(leftPre, leftIn);
        }
        if (mid < inOrderArr.length - 1) {
            // 当前节点有右子树，递归重建右子树
            int[] rightPre = Arrays.copyOfRange(preOrderArr, mid + 1, preOrderArr.length);
            int[] rightIn = Arrays.copyOfRange(inOrderArr, mid + 1, inOrderArr.length);
            root.right = reConstructBinaryTree(rightPre, rightIn);
        }
        return root;
    }

    public static void preOrderTraverse(TreeNode root) {
        if (root == null)
            return;
        System.out.print(root.val + " ");
        preOrderTraverse(root.left);
        preOrderTraverse(root.right);
    }

    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        TreeNode root = reConstructBinaryTree(pre, in);
        preOrderTraverse(root);
        System.out.println();
        System.out.println(countTreeNode(root));
    }

    public static int countTreeNode(TreeNode root) {
        if (root == null)
            return 0;
        return countTreeNode(root.left) + countTreeNode(root.right) + 1;
    }
}
