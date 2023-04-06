package org.example.leetcode.tree;

import org.example.TreeNode;

public class HashPathNum {
    /*
    112. 判断路径总和是否存在
     */
    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && root.val == sum) {
            return true;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
//        root1.right = new TreeNode(5);
        System.out.println(hasPathSum(root1, 1));
    }
}
