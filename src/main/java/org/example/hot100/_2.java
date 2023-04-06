package org.example.hot100;

import org.example.ListNode;

public class _2 {

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(9);

        ListNode head2 = new ListNode(5);
        head2.next = new ListNode(6);
        head2.next.next = new ListNode(4);
        head2.next.next.next = new ListNode(9);
        ListNode listNode = addTwoNumbers2(head, head2);
        while (listNode != null) {
            System.out.print(listNode.val);
            listNode = listNode.next;
        }

    }


    /**
     * 整形 位数不够  Integer.MAX_VALUE 2147483647 最多十位数
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        int n1 = 0;
        int r1 = 1;
        while (l1 != null) {
            n1 += l1.val * r1;
            r1 *= 10;
            l1 = l1.next;
        }
        int n2 = 0;
        int r2 = 1;
        while (l2 != null) {
            n2 += l2.val * r2;
            r2 *= 10;
            l2 = l2.next;
        }
        int sum = n1 + n2; // 807
        if (sum <= 0) {
            return new ListNode(0);
        }
        ListNode res = new ListNode(sum % 10);
        ListNode p = res;
        sum = sum / 10;
        while (sum > 0) {
            p.next = new ListNode(sum % 10);
            sum = sum / 10;
            p = p.next;
        }
        return res;
    }

    /**
     *
     * 每个个位数单独加
     */
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        int n1 = 0; // 统计l1个数
        ListNode p1 = l1;
        while (p1 != null) {
            p1 = p1.next;
            n1 += 1;
        }

        ListNode p2 = l2;
        int n2 = 0; // l2个数
        while (p2 != null) {
            p2 = p2.next;
            n2 += 1;
        }
        if (n1 == 0 || n2 == 0) return null;

        int swap;
        if (n1 < n2) { // l2比l1长，则把l2与l1交换
            p1 = l2;
            l2 = l1;
            l1 = p1;
            swap = n1;
            n1 = n2;
            n2 = swap;
        }
        ListNode res = new ListNode(0);
        ListNode p = res;
        int carry = 0;

        // 前面交换后 只有l1>=l2的情况

        // 计算=的部分
        for (int i = 1; i <= n2; i++) {
            int sum = l1.val + l2.val + carry;
            carry = sum >= 10 ? 1 : 0;
            p.next = new ListNode(sum % 10);
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        // 计算>的部分
        for (int i = n2 + 1; i <= n1; i++) {
            int sum = l1.val + carry;
            carry = sum >= 10 ? 1 : 0;
            p.next = new ListNode(sum % 10);
            p = p.next;
            l1 = l1.next;
        }
        // 最后剩下进位
        if (carry == 1) {
            p.next = new ListNode(carry);
        }
        return res.next;

    }
}
