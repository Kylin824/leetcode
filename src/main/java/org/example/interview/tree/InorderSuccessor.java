package org.example.interview.tree;

import org.example.TreeNode;

public class InorderSuccessor {
    /*
    面试题 04.06. 后继者
    设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
    如果指定节点没有对应的“下一个”节点，则返回null。

    1. 中序遍历 每个节点存入list

    2. 递归，利用BST性质
        当前节点小于等于p，则后继一定在右子树
        当前节点大于p，则一定在左子树或者是当前节点
    */

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null)
            return null;
        if (root.val <= p.val) {
            // 当前节点小于等于p，则后继一定在右子树
            return inorderSuccessor(root.right, p);
        }
        else {
            // 当前节点大于p，则一定在左子树或者自己就是
            TreeNode leftRet = inorderSuccessor(root.left, p);
            if (leftRet == null)
                return root;
            else
                return leftRet;
        }
    }
}
