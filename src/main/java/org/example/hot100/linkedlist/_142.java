package org.example.hot100.linkedlist;

import org.example.ListNode;

public class _142 {

    // 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。


    // 快慢指针
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
