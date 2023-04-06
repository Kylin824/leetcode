package org.example.leetcode.list;

import org.example.ListNode;

public class MergeTwoSortedList {
    /*
        21. 将两个有序的链表合并为一个新链表，要求新的链表是通过拼接两个链表的节点来生成的。
     */
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        if (l1 == null)
//            return l2;
//        if (l2 == null)
//            return l1;
//        ListNode dummy = new ListNode(-1);
//        ListNode p = dummy;
//        while (l1 != null && l2!= null) {
//            if (l1.val >= l2.val) {
//                p.next = l2;
//                l2 = l2.next;
//            }
//            else {
//                p.next = l1;
//                l1 = l1.next;
//            }
//            p = p.next;
//        }
//        p.next = l1 == null ? l2 : l1;
//        return dummy.next;
//    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            }
            else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = l1 == null ? l2 : l1;
        return dummy.next;
    }

    // 递归版
    public ListNode mergeTwoListsRecur(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
        }
        else {
            l2.next = mergeTwoLists(l2.next, l1);
        }
        return l1.val < l2.val ? l1 : l2;
    }
}
