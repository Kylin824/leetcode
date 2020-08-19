package org.example.leetcode.tree;

import org.example.leetcode.TreeNode;

import java.util.Arrays;

public class SortedArrayToBST {
    /*
    108.将有序数组转换为高度平衡二叉搜索树
    保证 每个节点 的左右两个子树的高度差的绝对值不超过 1。

    利用数组已排序的特点 二分查找
     */

    public static TreeNode buildBST(int[] nums) {
        return build(nums, 0, nums.length);
    }

    public static TreeNode build(int[] nums, int left, int right) {
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        int mid = left + () / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBST(Arrays.copyOfRange(nums, 0, mid));
        root.right = buildBST(Arrays.copyOfRange(nums, mid, nums.length));
        return root;
    }

    public static void main(String[] args) {
        int[] arr = {-10,-3,0,5,9};
        TreeNode ret = buildBST(arr);
        System.out.println("");
    }
}
