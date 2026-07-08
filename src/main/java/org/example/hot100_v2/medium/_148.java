package org.example.hot100_v2.medium;

import org.example.ListNode;

/**
 * @author kylin
 * @date 2026/7/9
 */

public class _148 {

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 双指针找到链表中点
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;

        // 归并排序
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);

        // 合并左右两个有序链表
        ListNode res = mergeList(left, right);

        return res;
    }

    public static ListNode mergeList(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        p.next = l1 == null ? l2 : l1;
        return dummy.next;
    }

    public static void main(String[] args) {
        // [-1,5,3,4,0]
        ListNode head = new ListNode(-1);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(0);
        sortList(head);
        ListNode.printList(head);
    }

}
