package org.example.company.shopee;


import org.example.leetcode.solved.Arrays;
import org.example.offer.ListNode;
import scala.Int;

import java.util.ArrayList;

public class ProblemThree {

    public static ListNode reverseLinkedList(ListNode head, int n) {
        // write code here
        ArrayList<Integer> list = new ArrayList<>();
        ListNode ptr = head;
        while (ptr != null) {
            list.add(ptr.val);
            ptr = ptr.next;
        }

        ListNode tail = new ListNode(-1);
        ListNode newHead = tail;
        int begin = 0;
        int count = 0;
        while (count < list.size()) {
            int end = 0;
            if (begin + n - 1 < list.size()) {
                end = begin + n - 1;
            }
            else {
                end = list.size() - 1;
            }

            while (end >= begin) {
                tail.next = new ListNode(list.get(end));
                tail = tail.next;
                end--;
                count++;
            }
            begin += n;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode tail = head;
        for (int i = 0; i < 5; i++) {
            ListNode node = new ListNode(i + 1);
            tail.next = node;
            tail = tail.next;
        }
        ListNode ptr = head;
        while (ptr != null) {
            System.out.print(ptr.val + " ");
            ptr = ptr.next;
        }
        System.out.println(">>>>>>>");
        ListNode newHead = reverseLinkedList(head, 4);
        ptr = newHead;
        while (ptr != null) {
            System.out.print(ptr.val + " ");
            ptr = ptr.next;
        }
        System.out.println();
    }
}
