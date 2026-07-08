package org.example.archive.hot100;

//给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
//
// 示例 1：
//
//输入：root = [3,1,4,null,2], k = 1
//输出：1
//
// 示例 2：
//
//输入：root = [5,3,6,2,4,null,null,1], k = 3
//输出：3
//
// 提示：
//
// 树中的节点数为 n 。
// 1 <= k <= n <= 10⁴
// 0 <= Node.val <= 10⁴
//
// 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 822 👎 0

import org.example.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _230 {

    // 中序遍历，遍历到的第k个即为第k大的值

    // 迭代版
    public int kthSmallest(TreeNode root, int k) {
        List<TreeNode> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root);
            root = root.right;
            if (res.size() == k) {
                return res.get(k - 1).val;
            }
        }
        return 0;
    }

    // 递归版
    public int kthSmallest1(TreeNode root, int k) {
        List<TreeNode> res = new ArrayList<>();
        inorder(root, res, k);
        return res.get(k - 1).val;
    }

    public void inorder(TreeNode root, List<TreeNode> res, int k) {
        if (root == null || res.size() == k) {
            return;
        }
        inorder(root.left, res, k);
        res.add(root);
        inorder(root.right, res, k);
    }

    public static void main(String[] args) {
        _230 a = new _230();
        TreeNode root = new TreeNode(30);
        root.left = new TreeNode(20);
        root.right = new TreeNode(40);
        root.left.left = new TreeNode(10);
        System.out.println(a.kthSmallest1(root, 2));
    }
}
