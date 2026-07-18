package org.example.hot100_v2.medium.linkedlist;

import org.example.ListNode;

/**
 * 删除链表中给定的节点
 * @author kylin
 * @date 2026/7/18
 */

public class _237 {

    public void deleteNode(ListNode node) {
        ListNode prev = node;
        while (node.next != null) {
            node.val = node.next.val;
            prev = node;
            node = node.next;
        }
        prev.next = null;
    }
}
