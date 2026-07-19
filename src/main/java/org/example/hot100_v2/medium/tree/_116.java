package org.example.hot100_v2.medium.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 填充完美二叉树每个节点的下一个右侧节点指针
 * 需常量空间O(1)  层序遍历可以实现但是O(n)
 *
 * @author kylin
 * @date 2026/7/20 0:04
 * @description TODO
 */

public class _116 {

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public static Node connectOn(Node root) {
        if (root == null) return null;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                node.next = i < size - 1 ? q.peek() : null;
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
        }
        return root;
    }


    // 利用完美二叉树的特点
    public static Node connectO1(Node root) {
        if (root == null) return null;
        Node firstLeft = root;
        // 是否还有下一层
        while (firstLeft.left != null) {
            Node head = firstLeft;
            while (head != null) {
                head.left.next = head.right;
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            firstLeft = firstLeft.left;
        }
        return root;
    }

    public static void main(String[] args) {
        _116 obj = new _116();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(obj.connectO1(root));
    }
}
