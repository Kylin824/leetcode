package org.example.interview.list;

import org.example.ListNode;

import java.util.HashSet;

public class RemoveDuplicate {
    /*
    面试题 02.01. 移除重复节点
    编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。

    set判断重复
     */
    public ListNode removeDuplicateNodes(ListNode head) {
        HashSet<Integer> set = new HashSet<>();
        ListNode p = head;
        ListNode pre = null;
        while (p != null) {
            if (!set.contains(p.val)) {
                set.add(p.val);
                pre = p;
                p = p.next;
            }
            else {
                pre.next = p.next;
                p = p.next;
            }
        }
        return head;
    }
}
