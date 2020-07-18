package org.example.offer.list;

import java.util.HashMap;

public class CopyList {
    /*
        NO.25
        输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针random指向一个随机节点），
        请对此链表进行深拷贝，并返回拷贝后的头结点。
     */
    /*
        思路:
            1. map存储每个节点的对应的random指针
            2. 不使用map，通过多次遍历

     */
    public static RandomListNode clone1(RandomListNode pHead) {

        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();

        RandomListNode cur = pHead;

        while (cur != null) {
            map.put(cur, new RandomListNode(cur.label));
            cur = cur.next;
        }

        cur = pHead;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(pHead);
    }


    static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
}
