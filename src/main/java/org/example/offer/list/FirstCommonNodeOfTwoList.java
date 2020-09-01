package org.example.offer.list;

import org.example.offer.ListNode;

public class FirstCommonNodeOfTwoList {
    /*
        NO.36
        输入两个链表，找出它们的第一个公共结点。
     */
    /*
        思路:
            快慢指针
            第一遍得到a和b之间的距离差
            第二遍使两个指针都从短链表开始往后找
            第三遍找到共同节点
     */
    public static ListNode findFirstCommonNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != null && p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        if (p1 == null) {
            p1 = headB;
        }
        else {
            p2 = headA;
        }
        while (p1 != null && p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        if (p1 == null) {
            p1 = headB;
        }
        else {
            p2 = headA;
        }
        while (p1 != null && p2 != null) {
            if (p1 == p2) {
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return null;
    }
}
