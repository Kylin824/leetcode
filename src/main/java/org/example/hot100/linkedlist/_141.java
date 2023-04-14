package org.example.hot100.linkedlist;

import org.example.ListNode;

import java.util.HashSet;
import java.util.Set;

public class _141 {

    // 给你一个链表的头节点 head ，判断链表中是否有环。


    // 空间复杂度：O(n)
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        Set<ListNode> nodes = new HashSet<>();
        while (head != null) {
            if (nodes.contains(head)) {
                return true;
            }
            nodes.add(head);
            head = head.next;
        }
        return false;
    }

    //快指针每次走两步、慢指针每次走一步
    public boolean hasCycle1(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
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
