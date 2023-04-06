package org.example.leetcode.tree;

import org.example.TreeNode;

import java.util.Arrays;

public class SortedArrayToBST {
    /*
    108.将有序数组转换为高度平衡二叉搜索树
    保证 每个节点 的左右两个子树的高度差的绝对值不超过 1。

    利用数组已排序的特点
     */

    public static TreeNode buildBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        int mid = nums.length / 2; // 取中位数作为根节点
        TreeNode root = new TreeNode(nums[mid]);
        if (mid > 0) {
            root.left = buildBST(Arrays.copyOfRange(nums, 0, mid)); // 左闭右开
        }
        if (mid + 1 < nums.length) {
            root.right = buildBST(Arrays.copyOfRange(nums, mid + 1, nums.length));
        }
        return root;
    }

    public static void main(String[] args) {
        int[] arr = {-10,-3,0,5,9};
        TreeNode ret = buildBST(arr);
        System.out.println("");
    }
}
