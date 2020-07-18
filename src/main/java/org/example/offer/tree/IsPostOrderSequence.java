package org.example.offer.tree;

import java.util.Arrays;

public class IsPostOrderSequence {
    /*
        NO.23
        输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。
     */
    /*
        思路:
            后序+二叉搜索树特点：
            最后一个节点为根节点，从前往后小于根节点的值都是左子树，大于根节点都在右子树
     */
    public static boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0)
            return false;
        int len = sequence.length;
        int root = sequence[len - 1];
        int left = 0;
        while (sequence[left] < root) {
            left++;
        }
        int right = left;
        while (right < len - 1) {
            if (sequence[right] < root) {
                return false;
            }
            right++;
        }
        boolean l = true;
        boolean r = true;
        if (left > 0)
            l = VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, left));
        if (left < len - 1)
            r = VerifySquenceOfBST(Arrays.copyOfRange(sequence, left, len - 1));
        return l && r;
    }

    public static void main(String[] args) {
//        int[] seq = {1,4,3,6,5,9,8,7};
//        int[] seq = {4,6,7,5};
//        int[] seq = {};
        int[] seq = {7,4,6,5};
        System.out.println(VerifySquenceOfBST(seq));
    }
}
