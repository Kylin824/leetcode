package org.example.offer.tree;

import org.example.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class SerializeTree {
    /*
        NO.61
        序列化与反序列化二叉树
     */
    /*
        思路:
           层序序列化与反序列化
           前序递归序列化与反序列化
     */

    public static String levelOrderSerialize(TreeNode root) {
        if (root == null)
            return "";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                sb.append("#,");
                continue;
            }
            sb.append(cur.val).append(",");
            queue.offer(cur.left);
            queue.offer(cur.right);
        }
        return sb.toString();
    }

    public static TreeNode levelOrderDeserialize(String str) {
        if (str.length() <= 0)
            return null;

        String[] nodes = str.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int index = 1;
        while (!queue.isEmpty() && index < nodes.length) {
            TreeNode tmp = queue.poll();
            if (!nodes[index].equals("#")) {
                TreeNode newLeft = new TreeNode(Integer.parseInt(nodes[index]));
                tmp.left = newLeft;
                queue.offer(newLeft);
            }
            index++;
            if (!nodes[index].equals("#") && index < nodes.length) {
                TreeNode newRight = new TreeNode(Integer.parseInt(nodes[index]));
                tmp.right = newRight;
                queue.offer(newRight);
            }
            index++;
        }
        return root;
    }

    public static String preOrderUnrecursiveSerialize(TreeNode root) {
        if (root == null)
            return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            TreeNode cur = stack.pop();
            if (cur != null) {
                sb.append(cur.val).append(",");
                stack.push(cur.right);
                stack.push(cur.left);
            } else
                sb.append("#,");
        }
        return sb.toString();
    }

    public static String preOrderSerialize(TreeNode root) {
        if (root == null)
            return "#,";
        StringBuilder sb = new StringBuilder();
        sb.append(root.val).append(",");
        sb.append(preOrderSerialize(root.left));
        sb.append(preOrderSerialize(root.right));
        return sb.toString();
    }

    static int index = -1;

    public static TreeNode preOrderDeserialize(String str) {
        String[] nodes = str.split(",");//将序列化之后的序列用，分隔符转化为数组
        index++; //索引每次加一
        if (index > nodes.length) {
            return null;
        }
        TreeNode root = null;
        if (!nodes[index].equals("#")) {//不是叶子节点 继续走 是叶子节点出递归
            root = new TreeNode(Integer.parseInt(nodes[index]));
            root.left = preOrderDeserialize(str);
            root.right = preOrderDeserialize(str);
        }
        return root;
    }

    public static void main(String[] args) {

        /* 初始化树
        [3, 9, 20, null, 11, 15, 17]
                    3
                   /  \
                 9     20
                  \   /  \
                  11 15  17
        */

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.right = new TreeNode(11);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(17);
        System.out.println(preOrderSerialize(root));
        System.out.println(preOrderUnrecursiveSerialize(root));

//        TreeNode rebuildRoot = levelOrderDeserialize("3,9,20,#,11,15,17,#,#,#,#,#,#,");
//        TreeNode rebuildRoot = preOrderDeserialize("3,9,#,11,#,#,20,15,#,#,17,#,#,");
//        System.out.println("test");
    }
}
