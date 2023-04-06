package org.example.interview.list;

import org.example.ListNode;

public class IsIntersect {
    /*
    面试题 02.07. 链表相交
    给定两个（单向）链表，判定它们是否相交并返回交点。
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

        if (p1 == null)
            p1 = headB;
        else
            p2 = headA;

        while (p1 != null && p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        if (p1 == null)
            p1 = headB;
        else
            p2 = headA;

        while (p1 != null && p2 != null) {
            if (p1 == p2) {
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(4);
        head1.next = new ListNode(1);
        head1.next.next = new ListNode(8);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        ListNode head2 = new ListNode(5);
        head2.next = new ListNode(0);
        head2.next.next = new ListNode(1);
        head2.next.next.next = head1.next.next;
        System.out.println(getIntersectionNode(head1, head2).val);
    }
}
