package org.example.hot100_v2.easy.tree;

import org.example.TreeNode;

import java.util.Arrays;

/**
 * @author kylin
 * @date 2026/7/13
 */
public class _108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        TreeNode root = new TreeNode(nums[nums.length / 2]);
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, nums.length / 2));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, nums.length / 2 + 1, nums.length));
        return root;
    }
}
