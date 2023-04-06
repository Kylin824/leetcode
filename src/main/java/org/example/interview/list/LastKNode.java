package org.example.interview.list;

import org.example.ListNode;

public class LastKNode {
    /*
    面试题 02.02. 返回倒数第 k 个节点
    实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
    给定的 k 保证是有效的。
     */
    public int kthToLast(ListNode head, int k) {
        ListNode fast = head, slow = head;
        while (k > 0) {
            k--;
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow.val;
    }
}
