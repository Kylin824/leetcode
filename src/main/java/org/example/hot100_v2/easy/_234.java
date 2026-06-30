package org.example.hot100_v2.easy;

import org.example.ListNode;

/**
 * 是否回文链表
 * @author kylin
 * @date 2026/6/29
 */
public class _234 {

    public boolean isPalindrome(ListNode head) {

        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 翻转
        ListNode pre = null;
        ListNode next;
        while (slow != null) {
            next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }

        while (head != null && pre != null && head != pre) {
            if (head.val != pre.val) {
                return false;
            }
            head = head.next;
            pre = pre.next;
        }
        return true;
    }

}
