package org.example.hot100_v2.medium.linkedlist;


import java.util.HashMap;
import java.util.Map;

/**
 * 随机链表的复制
 * @author kylin
 * @date 2026/7/20 2:15
 *
 */

public class _138 {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomListOn(Node head) {
        if (head == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    // 原地操作
    public Node copyRandomListO1(Node head) {
        // 原链表：A → B → C
        // 变成：  A → A' → B → B' → C → C'
        // 再拆成
        if (head == null) return null;

        Node cur = head;
        while (cur != null) {
            Node newNode = new Node(cur.val);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = newNode.next;
        }

        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        cur = head;
        Node newHead = head.next;

        while (cur != null) {
            Node copyNode = cur.next;
            if (copyNode.next != null) {
                copyNode.next = copyNode.next.next;
            }
            cur = cur.next;
        }
        return newHead;
    }

}
