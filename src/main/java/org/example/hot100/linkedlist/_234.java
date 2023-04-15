package org.example.hot100.linkedlist;

import org.example.ListNode;

public class _234 {

    public static void main(String[] args) {

        _234 o = new _234();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        o.isPalindrome(head);

    }


    public boolean isPalindrome(ListNode head) {

        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return true;
        }

        // slow定位到中间位置

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 反转slow后面的链表
        ListNode mid = slow;
        ListNode pre = null;
        while (mid != null) {
            ListNode next = mid.next;
            mid.next = pre;
            pre = mid;
            mid = next;
        }

        while (pre != null && head != null && pre != head) {
            if (pre.val != head.val) {
                return false;
            }
            pre = pre.next;
            head = head.next;
        }

        return true;
    }
}
