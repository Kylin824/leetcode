package org.example.leetcode.tree;

import org.example.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class AllPath {
    /*
    257. 二叉树的所有路径
    给定一个二叉树，返回所有从根节点到叶子节点的路径。
     */
    private static ArrayList<String> res = new ArrayList<>();
    private static ArrayList<Integer> path = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null)
            return res;
        path.add(root.val);
        if (root.left == null && root.right == null) {
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < path.size() - 1; i++) {
                s.append(path.get(i)).append("->");
            }
            s.append(path.get(path.size() - 1));
            res.add(s.toString());
        }
        if (root.left != null)
            binaryTreePaths(root.left);
        if (root.right != null)
            binaryTreePaths(root.right);

        // 回溯
        path.remove(path.size() - 1);
        return res;
    }
}
