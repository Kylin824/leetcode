package org.example.offer.bst.structure.linklist;

import org.example.ListNode;

public class Main {

    public void printCommonPart(ListNode head1, ListNode head2) {
        System.out.println("Common part: ");
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                head1 = head1.next;
            }
            else if (head1.val > head2.val) {
                head2 = head2.next;
            }
            else {
                System.out.println(head1.val + " ");
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        System.out.println();
    }
}
