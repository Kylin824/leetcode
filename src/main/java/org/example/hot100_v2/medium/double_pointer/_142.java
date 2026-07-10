package org.example.hot100_v2.medium.double_pointer;

import org.example.ListNode;

/**
 * @author kylin
 * @date 2026/7/10
 */

public class _142 {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast != slow) {
            return null;
        }
        // 到这说明有环
        // 关键点就是此时从slow和从head出发，一定会在入口相遇
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    public static void main(String[] args) {
        _142 obj = new _142();
        ListNode head = new ListNode(1);
        ListNode res = obj.detectCycle(head);
        System.out.println(res.val);
    }

}
