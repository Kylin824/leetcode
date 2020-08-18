package org.example.leetcode.list;

import org.example.leetcode.ListNode;

public class RemoveDuplicate {
    /*
    83. 删除链表重复元素
     */
    public static ListNode qs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head.next;
        ListNode pre = head;
        while (cur != null) {
            if (cur.val == pre.val) {
                pre.next = cur.next;
                cur = pre.next;
            }
            else {
                pre = pre.next;
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        ListNode p1 = head;
        while (p1 != null) {
            System.out.print(p1.val + " ");
            p1 = p1.next;
        }

        System.out.println();

        ListNode p2 = qs(head);
        while (p2 != null) {
            System.out.print(p2.val + " ");
            p2 = p2.next;
        }
    }
    
}
