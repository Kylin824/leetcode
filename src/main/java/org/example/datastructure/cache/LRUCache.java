package org.example.datastructure.cache;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {
    /*
    哈希表 + 双向链表

    双向链表按照被使用的顺序存储了这些键值对，靠近头部的键值对是最近使用的，而靠近尾部的键值对是最久未使用的。

    哈希表即为普通的哈希映射（HashMap），通过缓存数据的键映射到其在双向链表中的位置。

    get操作：
        key不存在返回-1
        key存在，通过hashmap定位到该节点在链表中的位置，并移动到双向链表的头部，最后返回该节点的值

     put操作：
        key不存在，使用key和value创建一个新的节点，在双向链表的头部添加该节点，并将kv加入hashmap。然后判断是否超过容量，超过容量则删除链表尾部节点，并删除hashmap中的kv
        key存在，与get操作类似。
     */

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

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // 返回  1
        cache.put(3, 3);    // 该操作会使得关键字 2 作废
        System.out.println(cache.get(2));       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得关键字 1 作废
        System.out.println(cache.get(1));       // 返回 -1 (未找到)
        System.out.println(cache.get(3));       // 返回  3
        System.out.println(cache.get(4));       // 返回  4
    }
}
