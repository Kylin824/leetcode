package org.example.offer.tree;

import org.example.TreeNode;

import java.util.ArrayList;

public class PathSumInTree {
    /*
        NO.24
        按字典序打印出二叉树中结点值的和为输入整数的所有路径。
     */
    /*
        思路:
            递归
     */

    private static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    private static ArrayList<Integer> path = new ArrayList<>();

    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

        if (root == null)
            return res;

        path.add(root.val);

        target = target - root.val;

        if (target == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<>(path));
        }

        // 否则继续往左往右找
        if (root.left != null)
            FindPath(root.left, target);
        if (root.right != null)
            FindPath(root.right, target);

        // 代码走到这里，表明要回溯，代表当前path中的root节点我已经不需要
        path.remove(path.size() - 1);

        return res;
    }

}
