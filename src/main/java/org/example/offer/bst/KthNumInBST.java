package org.example.offer.bst;

import org.example.offer.TreeNode;

import java.util.ArrayList;

public class KthNumInBST {
    /*
        NO.62
        给定一棵二叉搜索树，请找出其中的第k小的结点。
        例如（5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
                     5
                   /  \
                  3    7
                /  \  / \
               2   4 6   8
     */
    /*
        思路:
            二叉搜索树的中序遍历就是递增序列！！！
     */

        TreeNode KthNode(TreeNode pRoot, int k)
        {
            if (pRoot == null || k <= 0)
                return null;
            ArrayList<TreeNode> list = new ArrayList<>();
            InOrderTraverse(pRoot, list);
            return k <= list.size() ? list.get(k-1) : null;  // 如果k大于长度
        }

        void InOrderTraverse(TreeNode root, ArrayList<TreeNode> list) {
            if (root == null)
                return;
            InOrderTraverse(root.left, list);
            list.add(root);
            InOrderTraverse(root.right, list);
        }
}
