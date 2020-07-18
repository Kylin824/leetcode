package org.example.offer.tree;

import org.example.offer.TreeNode;

import java.util.ArrayList;

public class ConvertBSTtoList {
    /*
        NO.26
        输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
        要求不能创建任何新的结点，只能调整树中结点指针的指向。
     */
    /*
        思路:
            1. 辅助数组: 中序遍历记录每个节点，然后修改节点前后指针

            2. 中序递归做法，思路巧妙，符合题意不创建新节点
     */

    private static ArrayList<TreeNode> list = new ArrayList<>();

    public TreeNode Convert1(TreeNode root) {
        if (root == null)
            return null;
        InOrderTraverse(root); //中序遍历并生成顺序数组

        TreeNode head = list.get(0);
        TreeNode pre = head;
        for (int i = 1; i < list.size(); i++) {
            TreeNode cur = list.get(i);
            pre.right = cur;
            cur.left = pre;
            pre = cur;
        }
        list.clear();
        return head;
    }

    public static void InOrderTraverse(TreeNode root) {
        if (root == null)
            return;
        InOrderTraverse(root.left);
        list.add(root);
        InOrderTraverse(root.right);
    }

    private TreeNode pre = null ;

    public TreeNode Convert2(TreeNode root) {
        if (root == null)
            return null;
        Convert1(root.right);
        if (pre == null)
            pre = root;
        else {
            root.right = pre;
            pre.left = root;
            pre = root;
        }
        Convert2(root.left);
        return pre;
    }

}
