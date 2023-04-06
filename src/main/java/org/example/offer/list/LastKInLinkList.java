package org.example.offer.list;

import org.example.ListNode;

public class LastKInLinkList {
    /*
        NO.14
        输入一个链表，输出该链表中倒数第k个结点。
     */
    /*
        思路:
            快慢指针
     */
    public static ListNode FindKthToTail(ListNode head, int k) {
        ListNode fast = head;
        while (k > 0) {
            if (fast == null) // k超出范围，无效
                return null;
            fast = fast.next;
            k--;
        }
        ListNode slow = head;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
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
        System.out.println();

        ListNode k = FindKthToTail(head, 0);
        System.out.println(k.val);
    }
}
