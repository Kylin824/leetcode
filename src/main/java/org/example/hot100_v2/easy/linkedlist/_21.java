package org.example.hot100_v2.easy.linkedlist;

import org.example.ListNode;

/**
 * 合并两个有序链表
 * @author kylin
 * @date 2026/6/25
 */
public class _21 {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode head = mergeTwoLists(l1, l2);

        ListNode.printList(head);

    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode tail = new ListNode(0);
        head.next = tail;
        while (list1 != null && list2 != null) {
            if (list1.val >= list2.val) {
                tail.next = new ListNode(list2.val);
                list2 = list2.next;
            } else {
                tail.next = new ListNode(list1.val);
                list1 = list1.next;
            }
            tail = tail.next;
        }
        if (list1 == null && list2 !=null) {
            tail.next = list2;
        }
        if (list2 == null && list1 != null) {
            tail.next = list1;
        }
        return head.next.next;
    }
}
