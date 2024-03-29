package org.example.offer.list;

import org.example.ListNode;

public class MergeTwoSortedList {
    /*
        NO.16
        输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
     */
    /*
        思路:
            1. 双指针
            2. 递归
     */
    public ListNode Merge(ListNode list1, ListNode list2) {

        // 伪头节点
        ListNode vhead = new ListNode(-1);
        ListNode cur = vhead;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = list1 != null ? list1 : list2;
        return vhead.next;
    }

    public ListNode MergeRecursive(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 != null ? list1 : list2;
        }
        if (list1.val <= list2.val) {
            list1.next = MergeRecursive(list1.next, list2);
            return list1;
        }
        else {
            list2.next = MergeRecursive(list1, list2.next);
            return list2;
        }
    }
}
