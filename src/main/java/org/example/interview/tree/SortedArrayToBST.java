package org.example.interview.tree;

import org.example.TreeNode;

import java.util.Arrays;

public class SortedArrayToBST {
    /*
    面试题 04.02. 最小高度树
    给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。

    根节点在中间，建立根节点，再递归从左边数组建立左节点，右边数组建立右节点
     */

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        int rootIndex = nums.length / 2;
        TreeNode root = new TreeNode(nums[rootIndex]);
        if (rootIndex > 0) { // 左边有值
            root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, rootIndex));
        }
        if (rootIndex < nums.length - 1) {
            root.right = sortedArrayToBST(Arrays.copyOfRange(nums, rootIndex + 1, nums.length));
        }
        return root;
    }
}
