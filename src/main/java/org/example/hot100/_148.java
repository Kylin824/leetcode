package org.example.hot100;

//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
//
// 示例 1：
//
//
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
//
//
// 示例 2：
//
//
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
//
//
// 示例 3：
//
//
//输入：head = []
//输出：[]
//
//
//
//
// 提示：
//
//
// 链表中节点的数目在范围 [0, 5 * 10⁴] 内
// -10⁵ <= Node.val <= 10⁵
//
//
//
//
// 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
//
// Related Topics 链表 双指针 分治 排序 归并排序 👍 2248 👎 0

import org.example.ListNode;

public class _148 {

    // 排序链表（归并排序 & 递归版）
    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        // 快慢指针找中点
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 此时slow就是奇数的中间，偶数的中间两个左边那个
        ListNode rightHead = slow.next;
        slow.next = null; // 从中间切断，成为两条子链表

        // 递归sort两条子链表，=== 归并排序 分治
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        // 合并两条已排序的子链表
        ListNode tmpHead = new ListNode(-1);
        ListNode tail = tmpHead;

        while (left != null && right != null) {
            if (left.val < right.val) {
                tail.next = new ListNode(left.val);
                left = left.next;
            } else {
                tail.next = new ListNode(right.val);
                right = right.next;
            }
            tail = tail.next;
        }

        // 剩下要么left还有值，要么right还有值，直接加到末尾即可
        if (left != null) {
            tail.next = left;
        } else {
            tail.next = right;
        }

        return tmpHead.next;
    }

    public static void main(String[] args) {

        _148 a = new _148();
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        ListNode p = a.sortList(head);
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }

    }

}
