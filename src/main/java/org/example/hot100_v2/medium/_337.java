package org.example.hot100_v2.medium;

import org.example.TreeNode;

/**
 * @author kylin
 * @date 2026/7/10
 */

public class _337 {

    public int rob(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.val;
        if (root.left == null) {
            return Math.max(rob(root.right), root.val + rob(root.right.left) + rob(root.right.right));
        } else if (root.right == null) {
            return Math.max(rob(root.left), root.val + rob(root.left.left) + rob(root.left.right));
        }
        int lr = rob(root.left) + rob(root.right);
        int rs = root.val + rob(root.left.left) + rob(root.left.right) + rob(root.right.left) + rob(root.right.right);
        int max = Math.max(lr, rs);
        return max;
    }

    public static void main(String[] args) {
        _337 obj = new _337();

        // 7
//        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left.right = new TreeNode(3);
//        root.right.right = new TreeNode(1);


//        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(4);
//        root.right = new TreeNode(5);
//        root.left.left = new TreeNode(1);
//        root.left.right = new TreeNode(3);
//        root.right.right = new TreeNode(1);

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(2);
        root.left.left.right = new TreeNode(4);

        System.out.println(obj.rob(root));
    }

}
