package org.example.leetcode.list;

import org.example.ListNode;

public class IsHuiWenList {
    /*
    面试题 02.06. 回文链表
    编写一个函数，检查输入的链表是否是回文的。

    1. 反转整个链表 O(n)空间

    2. 找中点；反转前半部分
     */
    public static boolean isPalindrome(ListNode head) {
        if (head == null)
            return true;
        ListNode slow = head;
        ListNode fast = head;
        // 找中点
        // 1 2 3 4 3 2 1 中点为4
        // 1 2 3 3 2 1 中点为第一个3
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 此时slow就是中点, 反转后半部分的链表
        ListNode cur = slow.next;
        ListNode pre = null;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        slow.next = pre;

        // 匹配
        slow = head;
        fast = pre;
        while (fast != null) {
            if (slow.val != fast.val)
                return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(head));
    }
}
