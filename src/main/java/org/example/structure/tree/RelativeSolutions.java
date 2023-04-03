package org.example.structure.tree;

import java.util.*;

public class RelativeSolutions {

    public static void main(String[] args) {

        /* 初始化树
        [3, 9, 20, null, 11, 15, 17]
                    3
                   /  \
                 9     20
                  \   /  \
                  11 15  17
        */

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.right = new TreeNode(11);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(17);

    }

    /**
     * 非递归（迭代）中序遍历二叉树
     * @param root 根节点
     */
    public static void InOrderIter(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node); // 根指针入栈
                node = node.left; // 遍历左子树
            }
            node = stack.pop();
            System.out.print(node.val + " ");
            node = node.right;
        }
    }

    /**
     * 非递归（迭代）后序遍历二叉树
     * 类似先序非递归的思路，遍历根——>右子树——>左子树，最后把遍历结果翻转，就变为后序遍历
     * @param root 根节点
     */
    public static void PostOrderIter(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        List<Integer> list = new ArrayList<>();

        stack.push(node);

        while (!stack.isEmpty()) {
            node = stack.pop();
            list.add(node.val);
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }

        Collections.reverse(list);

        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }


    //递归获取树最大深度
    public static int MaxTreeDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(MaxTreeDepth(root.left), MaxTreeDepth(root.right)) + 1;
    }


}
