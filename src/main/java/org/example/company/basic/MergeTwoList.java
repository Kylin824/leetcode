package org.example.company.basic;

import org.example.leetcode.ListNode;

public class MergeTwoList {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
        }
        else {
            l2.next = mergeTwoLists(l2.next, l1);
        }
        return l1.val < l2.val ? l1 : l2;
    }

}
