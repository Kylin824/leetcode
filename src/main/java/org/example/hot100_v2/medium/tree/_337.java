package org.example.hot100_v2.medium.tree;

import org.example.TreeNode;

/**
 * @author kylin
 * @date 2026/7/10
 */

public class _337 {

    public int rob(TreeNode root) {
        int[] result = dfs(root);
        return Math.max(result[0], result[1]);
    }

    private int[] dfs(TreeNode node) {
        // 返回数组: [不偷当前节点的最大值, 偷当前节点的最大值]
        if (node == null) {
            return new int[]{0, 0};
        }

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        // 不偷当前节点：左右子节点可以偷或不偷，取最大值
        int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        // 偷当前节点：左右子节点都不能偷
        int rob = node.val + left[0] + right[0];

        return new int[]{notRob, rob};
    }

    public int robReserve(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.val;
        if (root.left == null) {
            return Math.max(rob(root.right), root.val + rob(root.right.left) + rob(root.right.right));
        } else if (root.right == null) {
            return Math.max(rob(root.left), root.val + rob(root.left.left) + rob(root.left.right));
        }
        int lr = rob(root.left) + rob(root.right);
        int rs = root.val + rob(root.left.left) + rob(root.left.right) + rob(root.right.left) + rob(root.right.right);
        return Math.max(lr, rs);
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
