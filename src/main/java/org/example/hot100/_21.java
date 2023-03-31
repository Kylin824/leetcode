package org.example.hot100;

import org.example.leetcode.ListNode;

public class _21 {


    public static void main(String[] args) {
        ListNode l1 = new ListNode(-9);
        l1.next = new ListNode(3);
//        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(7);
//        l2.next.next = new ListNode(4);

        ListNode node = mergeTwoLists(l1, l2);
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    // 双指针
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null && list2 != null) {
            return list2;
        }
        if (list1 != null && list2 == null) {
            return list1;
        }

        ListNode head;
        ListNode p;

        ListNode a;
        ListNode b;
        if (list1.val <= list2.val) {
            head = list1;
            a = list1.next;
            b = list2;
        } else {
            head = list2;
            a = list1;
            b = list2.next;
        }
        p = head;

        while (a != null && b != null) {
            if (a.val <= b.val) {
                p.next = a;
                a = a.next;
            } else {
                p.next = b;
                b = b.next;
            }
            p = p.next;
        }

        if (a == null) {
            while (b != null) {
                p.next = b;
                b = b.next;
                p = p.next;
            }
        } else if (b == null) {
            while (a != null) {
                p.next = a;
                a = a.next;
                p = p.next;
            }
        }
        return head;
    }
}
