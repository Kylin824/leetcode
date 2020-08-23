package org.example.leetcode.list;

import org.example.leetcode.ListNode;

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode p = head;
        ListNode pre = null;
        ListNode next = null;
        while (p != null) {
            next = p.next;

            p.next = pre;
            pre = p;

            p = next;
        }
        return pre;
    }

    public static void main(String[] args) {

    }
}
