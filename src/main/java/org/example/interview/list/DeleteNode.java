package org.example.interview.list;

import org.example.leetcode.ListNode;

public class DeleteNode {
    /*
    面试题 02.03. 删除节点
    实现一种算法，删除单向链表中给定的节点。

    示例：
    输入：单向链表a->b->c->d->e->f中的 **节点c**
    结果：不返回任何数据，但该链表变为a->b->d->e->f
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
