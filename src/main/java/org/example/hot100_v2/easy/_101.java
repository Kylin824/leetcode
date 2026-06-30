package org.example.hot100_v2.easy;

import org.example.TreeNode;

import java.util.Stack;

/**
 * 对称二叉树：判断二叉树是否轴对称
 *
 * @author kylin
 * @date 2026/6/29
 */
public class _101 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if ((left == null && right != null) || (left != null && right == null)) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }


    public boolean isSymmetricStack(TreeNode root) {
        if (root == null || root.left == null && root.right != null || root.right == null && root.left != null) {
            return false;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root.left);
        stack2.push(root.right);
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            TreeNode l = stack1.pop();
            TreeNode r = stack2.pop();
            if (l == null && r != null || l != null && r == null) {
                return false;
            }
            if (l != null && r != null) {
                if (l.val != r.val) {
                    return false;
                }
                stack1.push(l.left);
                stack1.push(l.right);
                stack2.push(r.right);
                stack2.push(r.left);
            }
        }
        return true;
    }
}
