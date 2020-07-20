package org.example.leetcode.list;

import org.example.leetcode.ListNode;

public class MergeTwoSortedList {
    /*
        LC85 将两个有序的链表合并为一个新链表，要求新的链表是通过拼接两个链表的节点来生成的。
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (l1 != null && l2!= null) {
            if (l1.val >= l2.val) {
                p.next = l2;
                l2 = l2.next;
            }
            else {
                p.next = l1;
                l1 = l1.next;
            }
            p = p.next;
        }
        p.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}
