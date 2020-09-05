package org.example.interview.list;

import org.example.leetcode.ListNode;

public class SplitList {
    /*
    面试题 02.04. 分割链表
    编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的节点之前。

    示例:
    输入: head = 3->5->8->5->10->2->1, x = 5
    输出: 3->1->2->10->5->5->8
    */
    public ListNode partition(ListNode head, int x) {
        ListNode cur = head; //当前节点
        ListNode prev = head; // 上一个
        while (cur != null) {
            if (cur.val < x) {
                int tmp = cur.val;
                cur.val = prev.val;
                prev.val = tmp;
                prev = prev.next;
            }
            cur = cur.next;
        }
        return head;
    }
}
