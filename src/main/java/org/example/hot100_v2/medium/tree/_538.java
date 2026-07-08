package org.example.hot100_v2.medium.tree;

import org.example.TreeNode;

/**
 * 二叉搜索树转为累加树
 * @author kylin
 * @date 2026/7/8
 *
 * 反向中序遍历
 */
public class _538 {

    public int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }
}
