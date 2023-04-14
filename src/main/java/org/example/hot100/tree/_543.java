package org.example.hot100.tree;

import org.apache.spark.sql.sources.In;
import org.example.TreeNode;

/**
 * @author kylin
 * @date 2023/4/14
 */
public class _543 {

    // 给定一棵二叉树，你需要计算它的直径长度。
    // 一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。

    public static void main(String[] args) {
        _543 o = new _543();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(o.diameterOfBinaryTree(root));
    }

    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        res = Math.max(left + right, res);  // 最长路径不一定经过根节点，所以用一个变量存最大值!
        return Math.max(left, right) + 1;
    }
}
