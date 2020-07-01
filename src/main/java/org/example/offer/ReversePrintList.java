package org.example.offer;

import java.util.ArrayList;
import java.util.ListIterator;

public class ReversePrintList {
    /*
        NO.3
        输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
     */
    /*
        思路:
            1. 第一个列表保存，倒序输出到第二个列表后返回
            2. 调整链表指针位置

        tips: ListIterator;
     */
    public static ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ArrayList<Integer> tmp = new ArrayList<>();
        while (listNode != null) {
            tmp.add(listNode.val);
            listNode = listNode.next;
        }

        ArrayList<Integer> res = new ArrayList<>();
        ListIterator<Integer> iterator = tmp.listIterator(tmp.size());
        while (iterator.hasPrevious()) {
            res.add(iterator.previous());
        }
        return res;
    }

    public static ArrayList<Integer> printListFromTailToHead2(ListNode head) {
        ArrayList<Integer> res = new ArrayList<>();
        ListNode cur = head;
        if (cur == null)
            return res;

        ListNode pre = null;
        ListNode next = null;

        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        ListNode ptr = pre;
        while (ptr != null) {
            res.add(ptr.val);
            ptr = ptr.next;
        }
        return res;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode tail = head;
        for (int i = 0; i < 5; i++) {
            ListNode node = new ListNode(i + 2);
            tail.next = node;
            tail = tail.next;
        }
        ListNode ptr = head;
        while (ptr != null) {
            System.out.print(ptr.val + " ");
            ptr = ptr.next;
        }
        System.out.println();

//        ListNode listNode = head;
//        ListNode pre = null;
//        ListNode next;
//        while (listNode != null) {
//            next = listNode.next;
//            listNode.next = pre;
//            pre = listNode;
//            listNode = next;
//        }
//        ptr = pre;
//        while (ptr != null) {
//            System.out.print(ptr.val + " ");
//            ptr = ptr.next;
//        }

        head = null;
        ArrayList<Integer> res = printListFromTailToHead2(head);
        for (Integer i : res) {
            System.out.print(i + " ");
        }
    }
}
