package org.example.company.basic;

import org.example.leetcode.ListNode;

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode cur = head;
        ListNode pre = null;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
