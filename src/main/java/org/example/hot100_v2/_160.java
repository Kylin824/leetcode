package org.example.hot100_v2;

import org.example.ListNode;

/**
 * 找出链表相交的位置
 * @author kylin
 * @date 2026/6/29
 */
public class _160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1.next != null && p2.next != null) {
            if (p1 == p2) {
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        if (p1.next == null) {
            p1 = headB;
            while (p2.next != null) {
                p2 = p2.next;
                p1 = p1.next;
            }
            p2 = headA;
            while (p2 != null) {
                if (p1 == p2) {
                    return p2;
                }
                p2 = p2.next;
                p1 = p1.next;
            }
        } else {
            p2 = headA;
            while (p1.next != null) {
                p1 = p1.next;
                p2 = p2.next;
            }
            p1 = headB;
            while (p1 != null) {
                if (p1 == p2) {
                    return p2;
                }
                p2 = p2.next;
                p1 = p1.next;
            }
        }
        return null;
    }

}
