package org.example.leetcode.list;

import org.example.ListNode;

public class CycleList {
    /*
    141. 环形链表
    给定一个链表，判断链表中是否有环。
     */

    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            if (fast == slow) {
                return true;
            }
            else {
                fast = fast.next.next;
                slow = slow.next;
            }
        }
        return false;
    }
}
