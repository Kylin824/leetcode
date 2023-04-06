package org.example.leetcode.list;

import org.example.ListNode;

public class LastKNode {
    /*
    剑指 Offer 22. 链表中倒数第k个节点
     */
    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head, slow = head;
        while (fast != null && k > 0) {
            k--;
            fast = fast.next;
        }
        if (fast == null) {
            if (k == 0) {
                return head;
            }
            else {
                return null;
            }
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(getKthFromEnd(head, 5).val);
    }
}
