package org.example.company.bigo;
import org.example.leetcode.ListNode;

public class Main {
    /*
    两两反转链表
    1-2-3-4-5-6
    2-1-4-3-6-5
    */
    public static ListNode reverseList(ListNode head) {
        ListNode p = head;
        if (p != null)
            return null;
        if (p.next != null)
            head = p.next;
        ListNode pre = null;
        ListNode next = null;
        ListNode lastP = null;
        while (p != null && p.next != null) {
            lastP = p;
            next = p.next.next;
            pre = p.next;
            pre.next = p;
            p.next = next;
            p = next;
            if (p != null && p.next != null) {
                lastP.next = p.next;
            }
            else {
                lastP.next = p;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode res = reverseList(head);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
