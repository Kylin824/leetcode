package org.example.offer;

import com.sun.org.apache.regexp.internal.REUtil;

import java.util.LinkedList;
import java.util.Queue;


public class SerializeTree {
    /*
        NO.61
        序列化与反序列化二叉树
     */
    /*
        思路:
           中序序列化
     */

    public static String Serialize(TreeNode root) {
        if (root == null)
            return "";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.val != '#')
                sb.append(cur.val).append(",");
            else {
                sb.append('#').append(",");
                continue;
            }

            if (cur.left != null && cur.right != null) {
                queue.offer(cur.left);
                queue.offer(cur.right);
            }

            if (cur.left == null && cur.right != null) {
                queue.offer(new TreeNode('#'));
                queue.offer(cur.right);
            }

            if (cur.left != null && cur.right == null) {
                queue.offer(cur.left);
                queue.offer(new TreeNode('#'));
            }

        }
        return sb.toString();
    }

    public static TreeNode Deserialize(String str) {
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.right = new TreeNode(11);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(17);
        System.out.println(Serialize(root));

        TreeNode rebuildRoot = Deserialize("3,9,20,#,11,15,17,");
    }
}
