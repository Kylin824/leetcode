package org.example.offer.list;

import org.example.offer.ListNode;

public class DeleteDupNodeInList {
    /*
        NO.56
        在一个**排序**的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
        例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
     */
    /*
        思路:
            1. Set去重 时间O(2n) 空间O(n)
                第一次遍历如果有重复则加入set，第二次遍历如果该节点在set中说明重复，直接删除

            2. 双指针
                vhead伪头节点
                pre指向有效的上一个节点
                cur遍历链表
                    1) 当遇到重复值时，进入while循环，直接走到下一个值的位置，同时使pre指向此位置
                    2) 当不重复时，cur赋值给pre，cur继续往后走
     */
    public ListNode deleteDuplication(ListNode pHead)
    {
        if (pHead == null || pHead.next == null)
            return pHead;
        ListNode vhead = new ListNode(-1); // 伪头节点
        vhead.next = pHead;
        ListNode pre = vhead;
        ListNode cur = pHead;
        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
                while (cur.next != null && cur.next.val == cur.val)
                    cur = cur.next;
                cur = cur.next; // 遍历直到cur的下一个值不等于cur 再往后走一步跳过这个重复的值
                pre.next = cur;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return vhead.next;
    }

    public static void main(String[] args) {
    }
}
