package org.example.median;

import org.example.leetcode.ListNode;

public class _19RemoveNthNodeFromList {
    /*
    19. 删除链表的倒数第N个节点
    给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

    示例：

    给定一个链表: 1->2->3->4->5, 和 n = 2.

    当删除了倒数第二个节点后，链表变为 1->2->3->5.
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode pre = null;
        ListNode slow = head;
        while (n >= 0 && fast != null) {
            fast = fast.next;
            n--;
        }
        if (fast == null && n == 0) {
            return head.next; // 删除倒数第一个节点
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode res = removeNthFromEnd(head, 5);
        while (res != null) {
            System.out.print(res.val + "->");
            res = res.next;
        }
    }
}
