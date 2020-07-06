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

              情况1: 1->2 当前节点是父节点的左孩子 下一节点是父节点
              情况2: 2->3、3->4、6->7 当前节点  下一节点是右孩子节点的最左孩子节点
              情况3: 4->5 当前节点是父节点的右孩子 节点是父父节点的左孩子
              情况4: 7->null 最尾节点
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
}
