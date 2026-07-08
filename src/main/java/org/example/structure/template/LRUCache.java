package org.example.structure.template;

import java.util.HashMap;

public class LRUCache {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;
        public Node() {}
        public Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    private int capacity; // 总容量
    private int size; // 已使用的空间大小
    private HashMap<Integer, Node> map;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new Node(); // 伪头部
        tail = new Node(); // 伪尾部
        map = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null)
            return -1;
        moveToHead(node);
        return node.value;
    }

    public void moveToHead(Node node) {
        // 修改前后节点指针
        removeNode(node);
        // 插入链表头
        addToHead(node);
    }

    public void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addToHead(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null) {
            // key不存在，则新建
            node = new Node(key, value);
            // 添加进哈希表
            map.put(key, node);
            // 插入头部
            addToHead(node);
            // 已使用+1
            size++;
            // 如果超过容量，删除尾部节点
            if (size > capacity) {
                Node lastNode = removeTail();
                map.remove(lastNode.key);
                size--;
            }
        }
        else {
            // 如果node存在，则移动到链表头部
            node.value = value;
            moveToHead(node);
        }
    }

    public Node removeTail() {
        Node lastNode = tail.prev;
        removeNode(lastNode);
        return lastNode;
    }
    
}
