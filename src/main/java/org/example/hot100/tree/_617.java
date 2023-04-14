package org.example.hot100.tree;

import org.example.TreeNode;
import scala.Int;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author kylin
 * @date 2023/4/14
 */
public class _617 {

    // 合并两个二叉树，重叠的值相加

    public static void main(String[] args) {
        _617 o = new _617();

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.left.left = new TreeNode(3);

        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(2);
        root2.right.right = new TreeNode(3);

        System.out.println(o.depth(root1));
        System.out.println(o.depth(root2));

        o.levelOrderPrint(root1, 3);
        System.out.println();
        o.levelOrderPrint(root2,3);
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        List<TreeNode> tree1 = new ArrayList<>();
        List<TreeNode> tree2 = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        List<TreeNode> res = new ArrayList<>();
        int len = Math.max(tree1.size(), tree2.size());
        for (int i = 0; i < len; i++) {
            TreeNode n1 = null, n2 = null;
            if (i < tree1.size() && i < tree2.size()) {
                n1 = tree1.get(i);
                n2 = tree2.get(i);
            }
            if (i > tree1.size()) {
                n2 = tree2.get(i);
            }
            if (i > tree2.size()) {
                n1 = tree1.get(i);
            }
            TreeNode node;
            if (n1 == null && n2 == null) {
                res.add(null);
                continue;
            }else if (n1 == null) {
                node = new TreeNode(n2.val);
            }else if (n2 == null) {
                node = new TreeNode(n1.val);
            }else {
                node = new TreeNode(n1.val + n2.val);
            }
            res.add(node);
        }

        // 中序重建树
        len = 1;
        queue.clear();
        queue.offer(res.get(0));
        while (!queue.isEmpty()) {
            int count = (int) (Math.log(len) / Math.log(2)) + 1;
            while (count > 0) {
                TreeNode node = queue.poll();
                if (node != null) {
                    if (len < res.size()) {
                        node.left = res.get(len++);
                        queue.offer(node.left);
                    }
                    if (len < res.size()) {
                        node.right = res.get(len++);
                        queue.offer(node.right);
                    }
                }
                count--;
            }
        }

        System.out.println();

        queue.offer(res.get(0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                size--;
                if (node == null) {
                    System.out.print("null ");
                    continue;
                }
                queue.offer(node.left);
                queue.offer(node.right);
                System.out.print(node.val + " ");
            }
        }

        return res.get(0);
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }

    public void levelOrderTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                size--;
                if (node == null) {
                    System.out.print("null ");
                    continue;
                }
                queue.offer(node.left);
                queue.offer(node.right);
                System.out.print(node.val + " ");
            }
        }
    }


    public void levelOrderPrint(TreeNode root, int depth) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int curDepth = 0;
        while (!queue.isEmpty()) {
            curDepth++;
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                size--;
                if (node == null) {
                    if (curDepth <= depth) {
                        queue.offer(null);
                        queue.offer(null);
                        System.out.print("null ");
                    }
                    continue;
                }
                queue.offer(node.left);
                queue.offer(node.right);
                System.out.print(node.val + " ");
            }
        }
    }

    // 层序列表重建树
    public TreeNode inorderToTree(List<Integer> list) {
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(list.get(0));
        queue.offer(root);

        while (!queue.isEmpty()) {

        }
    }

}
