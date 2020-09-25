package org.example.offer.list;

import org.example.offer.ListNode;

public class ReverseList {
    /*
        NO.15
        输入一个链表，反转链表后，输出新链表的表头。
     */
    /*
        思路: 同 NO.03，三个指针，修改每个节点的pre和next
     */
    public static ListNode ReverseList(ListNode head) {

        if (head == null || head.next == null)
            return head;
        ListNode cur = head;
        ListNode pre = null;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode tail = head;
        for (int i = 0; i < 5; i++) {
            ListNode node = new ListNode(i + 1);
            tail.next = node;
            tail = tail.next;
        }
        ListNode ptr = head;
        while (ptr != null) {
            System.out.print(ptr.val + " ");
            ptr = ptr.next;
        }
        System.out.println(">>>>>>>");
        ListNode newHead = ReverseList(head);
        ptr = newHead;
        while (ptr != null) {
            System.out.print(ptr.val + " ");
            ptr = ptr.next;
        }
        System.out.println();
    }

}
