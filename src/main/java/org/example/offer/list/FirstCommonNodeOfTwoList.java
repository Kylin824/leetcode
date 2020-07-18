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
    public static ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null)
            return null;
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;

        // 第一次遍历让长链表上的指针走短链表的长度
        while (p1.next != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        // 短链表指针走到最后
        if (p1.next == null)
            p1 = pHead2;
        else
            p2 = pHead1;

        // 第二次遍历让长链表上的指针走到和短链表指针起始的位置
        while (p1.next != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        if (p1.next == null)
            p1 = pHead2;
        else
            p2 = pHead1;
        // 此时p1,p2都从短的链表位置开始往后走
        while (p1 != p2 && p1.next != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1 == p2 ? p1 : null;
    }

}
