package org.example.interview.tree;

import org.example.leetcode.TreeNode;

public class BinTreeToList {
    /*
    面试题 17.12. BiNode
    二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。
    实现一个方法，把二叉搜索树转换为单向链表，要求依然符合二叉搜索树的性质，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。
    返回转换后的单向链表的头节点。

    示例：
    输入： [4,2,5,1,3,null,6,0]
    输出： [0,null,1,null,2,null,3,null,4,null,5,null,6]

    中序遍历并修改节点的左右指针
    */

    TreeNode dummy = new TreeNode(-1);
    TreeNode prev = null;

    public TreeNode convertBiNode(TreeNode root) {
        convert(root);
        return dummy.right;
    }

    public void convert(TreeNode root) {
        if (root == null)
            return;

        convert(root.left);

        if (prev == null) { // 最左下角节点才成立
            prev = root;
            dummy.right = root;
        }
        else {
            prev.right = root; // 中序序列中上一节点的右指针指向自己
            prev = root; // 自己变为下一节点的上一节点
        }
        root.left = null;

        convert(root.right);
    }
}
