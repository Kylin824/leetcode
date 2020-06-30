package org.example.offer;

import java.util.Arrays;

import static org.example.offer.Utils.PreOrderTraverse;

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
    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root = new TreeNode(pre[0]);
        // only root
        if (pre.length == 1 && in.length == 1) {
            root.left = null;
            root.right = null;
            return root;
        }

        int split = 0;
        while (in[split] != pre[0])
            split++;

        if (split == 0) {
            // no left tree
            int[] rightPre = Arrays.copyOfRange(pre, split + 1, pre.length);
            int[] rightIn = Arrays.copyOfRange(in, split + 1, in.length);
            root.right = reConstructBinaryTree(rightPre, rightIn);
        }
        else if (split == in.length - 1) {
            // no right
            int[] leftPre = Arrays.copyOfRange(pre, 1, split + 1);
            int[] leftIn = Arrays.copyOfRange(in, 0, split);
            root.left = reConstructBinaryTree(leftPre, leftIn);
        }
        else {
            int[] leftPre = Arrays.copyOfRange(pre, 1, split + 1);
            int[] leftIn = Arrays.copyOfRange(in, 0, split);
            int[] rightPre = Arrays.copyOfRange(pre, split + 1, pre.length);
            int[] rightIn = Arrays.copyOfRange(in, split + 1, in.length);
            root.left = reConstructBinaryTree(leftPre, leftIn);
            root.right = reConstructBinaryTree(rightPre, rightIn);
        }
        return root;
    }

    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        TreeNode root = reConstructBinaryTree(pre, in);
        PreOrderTraverse(root);

    }
}
