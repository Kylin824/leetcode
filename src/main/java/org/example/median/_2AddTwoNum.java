package org.example.median;

import org.example.leetcode.ListNode;

public class _2AddTwoNum {
    /*
    2. 两数相加
    给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
    如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
    您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

    示例：
    输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
    输出：7 -> 0 -> 8
    原因：342 + 465 = 807

    思路：
        求和进位

    进阶：
        结合反转链表
    */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            carry = 0;
            if (sum >= 10) {
                sum = sum % 10;
                carry = 1;
            }
            p.next = new ListNode(sum);
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l2 != null) {
            l1 = l2;
        }
        while (l1 != null) {
            int sum = l1.val + carry;
            if (sum >= 10) {
                sum = sum % 10;
                carry = 1;
            }
            p.next = new ListNode(sum);
            p = p.next;
            l1 = l1.next;
        }
        if (carry == 1) {
            p.next = new ListNode(carry);
        }
        return dummy.next;
    }
}
