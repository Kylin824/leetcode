package org.example.hot100;

import org.example.leetcode.ListNode;

public class _19 {

    /*
    删除链表的倒数第 n 个结点，并且返回链表的头结点。
     */

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
        ListNode node = removeNthFromEnd(head, 4);
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    // 双指针
    // 快慢指针
    public static ListNode removeNthFromEnd(ListNode head, int n) {

        if (head.next == null || n <= 0) {
            return null;
        }

        ListNode fast = head, slow = head;
        ListNode begin = new ListNode(0);
        begin.next = head;
        ListNode preSlow = begin;

        while (n > 0) {

            if (fast == null) {
                return null;
            }

            fast = fast.next;
            n--;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
            preSlow = preSlow.next;
        }

        preSlow.next = slow.next;

        return begin.next;

    }
}
