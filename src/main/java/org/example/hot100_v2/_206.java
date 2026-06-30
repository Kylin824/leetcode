package org.example.hot100_v2;

import org.example.ListNode;

import java.util.Stack;

public class _206 {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = head.next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public ListNode reverseListRecur(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = head.next;
        ListNode sHead = reverseListRecur(head.next);
        head.next = null;
        p.next = head;
        return sHead;
    }

    public ListNode reverseListStack(ListNode head) {
        if (head == null || head.next == null) return head;
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        head = stack.pop();
        ListNode tail = head;
        while (!stack.isEmpty()) {
            tail.next = stack.pop();
            tail = tail.next;
        }
        tail.next = null;
        return head;
    }
}
