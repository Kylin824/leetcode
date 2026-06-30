package org.example.hot100_v2.easy;

import org.example.ListNode;

/**
 * 链表是否有环
 * @author kylin
 * @date 2026/6/29
 */
public class _141 {

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

}
