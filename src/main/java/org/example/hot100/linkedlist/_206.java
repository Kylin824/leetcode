package org.example.hot100.linkedlist;

import org.example.ListNode;

public class _206 {

    // 反转链表

    // 双指针
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    // 递归
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        return reverse(null, head);
    }

    public ListNode reverse(ListNode pre, ListNode cur) {
        if (cur == null) {
            return pre;
        }
        ListNode next = cur.next;
        cur.next = pre;
        return reverse(cur, next);
    }
}
