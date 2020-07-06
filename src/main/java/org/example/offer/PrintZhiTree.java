package org.example.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class PrintZhiTree {
    /*
        NO.59
        请实现一个函数按照之字形打印二叉树
        即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        if (pRoot == null)
            return ret;
        Queue<TreeNode> queue = new LinkedList<>(); // 层序遍历
        queue.offer(pRoot);
        int depth = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            ArrayList<Integer> leverNodes = new ArrayList<>();
            while (size > 0) {
                TreeNode cur = queue.poll();
                if (cur.left != null)
                    queue.offer(cur.left);
                if (cur.right != null)
                    queue.offer(cur.right);
                leverNodes.add(cur.val);
                size--;
            }
            if (depth % 2 != 0) {
                Collections.reverse(leverNodes); // 奇数层则反转
                ret.add(leverNodes);
            } else {
                ret.add(leverNodes); // 偶数层则直接添加
            }
            depth++;
        }
        return ret;
    }
}
