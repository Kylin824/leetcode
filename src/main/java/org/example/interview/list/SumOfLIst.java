package org.example.interview.list;

import org.example.leetcode.ListNode;

public class SumOfLIst {
    /*
    面试题 02.05. 链表求和
    给定两个用链表表示的整数，每个节点包含一个数位。
    这些数位是反向存放的，也就是个位排在链表首部。
    编写函数对这两个整数求和，并用链表形式返回结果。
     */

    // 转成整型做加法 会超过范围
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1;
        long sum = 0;
        long k = 1;
        while (p != null) {
            sum = sum + (p.val * k);
            k *= 10;
            p = p.next;
        }
        p = l2;
        k = 1;
        while (p != null) {
            sum = sum + (p.val * k);
            k *= 10;
            p = p.next;
        }
        int tmp = (int) (sum % 10);
        ListNode res = new ListNode(tmp);
        p = res;
        sum = sum / 10;
        while (sum != 0) {
            tmp = (int) (sum % 10);
            p.next = new ListNode(tmp);
            p = p.next;
            sum = sum / 10;
        }
        return res;
    }

    public static ListNode addTwoNumbersOpt(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        int carry = 0; // 进位
        int sum;
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + carry;
            if (sum < 10) {
                p.next = new ListNode(sum);
                carry = 0;
            } else {
                p.next = new ListNode((sum) % 10);
                carry = 1;
            }
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            sum = l1.val + carry;
            if (sum < 10) {
                p.next = new ListNode(sum);
                carry = 0;
            } else {
                p.next = new ListNode((sum) % 10);
                carry = 1;
            }
            p = p.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            sum = l2.val + carry;
            if (sum < 10) {
                p.next = new ListNode(sum);
                carry = 0;
            } else {
                p.next = new ListNode((sum) % 10);
                carry = 1;
            }
            p = p.next;
            l2 = l2.next;
        }
        if (carry == 1) {
            p.next = new ListNode(1);
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode p1 = new ListNode(9);
        ListNode p2 = new ListNode(1);
        p2.next = new ListNode(9);
        p2.next.next = new ListNode(9);
        ListNode n = addTwoNumbersOpt(p1, p2);
        while (n != null) {
            System.out.print(n.val + " ");
            n = n.next;
        }
    }
}
