package org.example.offer.list;

import org.example.ListNode;

import java.util.HashMap;
import java.util.Map;

public class FindRingInList {
    /*
        NO.55
        给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
     */
    /*
        思路:
            1. 哈希表记录访问过的节点 空间O(n)

            2. 快慢指针 空间O(1)
                快指针每次往后走两步
                慢指针每次往后走一步
                最终有两种情况：
                    1、快指针走到链尾，返回false
                    2、慢指针==快指针，说明在环中相遇，返回true
     */

    public static ListNode EntryNodeOfLoop(ListNode pHead) {
        Map<ListNode, Integer> map = new HashMap<>();
        while (pHead != null) {
            if (map.get(pHead) == null) {
                map.put(pHead, 1);
            }
            else {
                map.put(pHead, map.get(pHead) + 1);
            }
            if (map.get(pHead) > 1)
                return pHead;
            pHead = pHead.next;
        }
        return null;
    }

    public static ListNode EntryNodeOfLoop1(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return null;
        ListNode slow = pHead;
        ListNode fast = pHead;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast)
                break;
        }
        if (fast == null || fast.next == null)
            return null;
        fast = pHead;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = head.next.next;
        ListNode node = EntryNodeOfLoop1(head);
        System.out.println(node.val);
    }
}
