package org.example.offer.tree;

import org.example.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrintTree {
    /*
        NO.60
        从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
     */

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(pRoot);
        while (q.size() > 0) {
            int size = q.size();
            ArrayList<Integer> level = new ArrayList<>();
            while (size-- > 0) {
                TreeNode cur = q.poll();
                if (cur.left != null)
                    q.offer(cur.left);
                if (cur.right != null)
                    q.offer(cur.right);
                level.add(cur.val);
            }
            res.add(level);
        }
        return res;
    }
}
