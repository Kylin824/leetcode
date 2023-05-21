package org.example.hot100.structure;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private Map<Integer, Node> map;
    private int capacity;
    private int size;
    private Node head, tail;
    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        public Node() {};

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public LRUCache(int capacity) {
        head = new Node();
        tail = new Node();
        this.capacity = capacity;
        this.size = 0;
        map = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {

        Node node = map.get(key);
        if (node == null) {
            return -1;
        }

        // 移动到表头

        // 删除node
        node.prev.next = node.next;
        node.next.prev = node.prev;

        // 表头插入node
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;

        return node.val;

    }

    public void put(int key, int value) {

        Node node = map.get(key);
        if (node == null) {

            node = new Node(key, value);

            map.put(key, node);

            // 表头插入node
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;

            size++;

            if (size > capacity) {

                // 删除表尾

                Node lastNode = tail.prev;
                lastNode.prev.next = lastNode.next;
                lastNode.next.prev = lastNode.prev;

                map.remove(lastNode.key);

                size--;
            }

        } else {
            node.val = value;

            // 移动到表头

            // 删除node
            node.prev.next = node.next;
            node.next.prev = node.prev;

            // 表头插入node
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

    }

}
