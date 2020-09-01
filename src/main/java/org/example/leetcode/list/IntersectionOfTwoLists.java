package org.example.leetcode.list;

import org.example.leetcode.ListNode;

import java.util.jar.JarEntry;

public class IntersectionOfTwoLists {
    /*
    160. 相交链表
    编写一个程序，找到两个单链表相交的起始节点。
     */

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != null && p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        if (p1 == null) {
            p1 = headB;
        }
        else {
            p2 = headA;
        }
        while (p1 != null && p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        if (p1 == null) {
            p1 = headB;
        }
        else {
            p2 = headA;
        }
        while (p1 != null && p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1 == p2 ? p1 : null;
    }
}
