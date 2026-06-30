package org.example.hot100_v2.easy;

import org.example.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树中序遍历
 * @author kylin
 * @date 2026/6/29
 */
public class _94 {

    /**
     * ps：[1,null,2,3]
     *
     *      1
     *       \
     *        2
     *       /
     *      3
     *
     * 前序遍历：打印 - 左 - 右 ：[1,2,3]
     * 中序遍历：左 - 打印 - 右 ：[1,3,2]
     * 后序遍历：左 - 右 - 打印 ：[3,2,1]
     */

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(res, root);
        return res;
    }

    public void inorder(List<Integer> res, TreeNode p) {
        if (p == null) {
            return;
        }
        inorder(res, p.left);
        res.add(p.val);
        inorder(res, p.right);
    }


    public List<Integer> inorderTraversalStack(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}
