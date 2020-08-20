package org.example.leetcode.tree;

import org.example.leetcode.TreeNode;

import java.util.Arrays;

public class SortedArrayToBST {
    /*
    108.将有序数组转换为高度平衡二叉搜索树
    保证 每个节点 的左右两个子树的高度差的绝对值不超过 1。

    利用数组已排序的特点
     */

    public static TreeNode buildBST(int[] nums) {
        return build(nums);
    }

    public static TreeNode build(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        int cur = nums.length / 2;
        TreeNode root = new TreeNode(nums[cur]);
        if (cur > 0) {
            root.left = build(Arrays.copyOfRange(nums, 0, cur));
        }
        if (cur + 1 < nums.length) {
            root.right = build(Arrays.copyOfRange(nums, cur + 1, nums.length));
        }
        return root;
    }

    public static void main(String[] args) {
        int[] arr = {-10,-3,0,5,9};
        TreeNode ret = buildBST(arr);
        System.out.println("");
    }
}
