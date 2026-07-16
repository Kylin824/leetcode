package org.example.hot100_v2.medium.double_pointer;

import org.example.ListNode;

/**
 * @author kylin
 * @date 2026/7/16
 */
public class _19 {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        ListNode q = head;
        for (int i = 1; i <= n; i++) {
            p = p.next;
        }
        // 第一轮就跑到底，说明n=链表长度，直接去掉第一个返回
        if (p == null) {
            return head.next;
        }
        while (p.next != null) {
            q = q.next;
            p = p.next;
        }
        // p到头，此时q是倒数第n-1个节点
        q.next = q.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
        ListNode root = removeNthFromEnd(head, 1);
        ListNode.printList(root);
    }
}
