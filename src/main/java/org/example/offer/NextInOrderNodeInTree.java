package org.example.offer;

import java.util.ArrayList;

public class NextInOrderNodeInTree {
    /*
        NO.57
        给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
        注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。

        {8,6,10,5,7,9,11},5  输出6
     */
    /*
        思路:
            1. 暴力法
                a. 从pNode一直next找到根节点
                b. 从根节点中序遍历得到数组
                c. 遍历数组，得到pNode的下一个值

            2. 分析中序树
                            6
                           / \
                          2   7
                         / \
                        1   5
                           /
                          3
                           \
                            4

              情况1: 2->3、3->4、6->7 当前节点有右孩子  则下一节点是右孩子节点的最左孩子节点
              情况2: 1->2 4->5 当前节点有父节点 则下一节点是该节点一直往上第一个有左节点的节点
              情况3: 7->null 最尾节点
     */

    class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null; // 指向父节点

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        TreeLinkNode root = null;
        TreeLinkNode tmp = pNode;
        // 找到根节点
        while (tmp != null) {
            root = tmp;
            tmp = tmp.next;
        }
        ArrayList<TreeLinkNode> list = new ArrayList<>();
        InOrderTraverse(root, list);
        int n = list.size();
        for (int i = 0; i < n; i++) {
            if (list.get(i) == pNode && i + 1 != n)
                return list.get(i+1);
        }
        return null;
    }

    public void InOrderTraverse(TreeLinkNode pNode, ArrayList<TreeLinkNode> list) {
        if (pNode == null)
            return;
        InOrderTraverse(pNode.left, list);
        list.add(pNode);
        InOrderTraverse(pNode.right, list);
    }

    public TreeLinkNode getNext1(TreeLinkNode pNode) {
        if (pNode == null)
            return null;

        if (pNode.right != null) {
            // 当前节点有右孩子，则下一个节点是有孩子节点的最左孩子节点  情况一：[2, 3, 6]
            pNode = pNode.right; // 从当前节点的右孩子开始
            while (pNode.left != null)
                pNode = pNode.left; // 往左一直走
            return pNode;
        }

        // 当前节点无右孩子，同时有父节点   情况二：[1,4]
        while (pNode.next != null) {
            TreeLinkNode root = pNode.next; //指向父节点
            if (root.left == pNode) { // 遇到第一个有左节点的节点
                return root;
            }
            pNode = pNode.next; // 否则继续往上走
        }

        //最尾节点
        return null;
    }
}
