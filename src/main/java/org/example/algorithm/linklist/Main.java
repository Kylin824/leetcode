package org.example.algorithm.linklist;

import com.sun.org.apache.xpath.internal.SourceTree;

public class Main {
    public static void main(String[] args) {

    }

    public void printCommonPart(Node head1, Node head2) {
        System.out.println("Common part: ");
        while (head1 != null && head2 != null) {
            if (head1.value < head2.value) {
                head1 = head1.next;
            }
            else if (head1.value > head2.value) {
                head2 = head2.next;
            }
            else {
                System.out.println(head1.value + " ");
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        System.out.println();
    }
}
