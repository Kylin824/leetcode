package org.example.hot100.tree;

import org.example.TreeNode;

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
        root1.right = new TreeNode(1);
        root1.right.left = new TreeNode(2);

        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(1);
        root2.right.right = new TreeNode(1);
        root2.right.right.right = new TreeNode(1);
        root2.right.right.right.left = new TreeNode(2);

        TreeNode treeNode = o.mergeTrees(root1, root2);
        System.out.println(treeNode);
    }


    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode merge = new TreeNode(root1.val + root2.val);
        merge.left = mergeTrees(root1.left, root2.left);
        merge.right = mergeTrees(root1.right, root2.right);
        return merge;
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


    // 树高度
    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }

    // 树转层序列表
    public List<Integer> treeToList(TreeNode root, int depth) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
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
                        res.add(null);
                    }
                    continue;
                }
                queue.offer(node.left);
                queue.offer(node.right);
                res.add(node.val);
            }
        }
        return res;
    }

    // 层序列表重建树
    public TreeNode listToTree(List<Integer> list) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(list.get(0));
        queue.offer(root);
        int count = 1;
        while (!queue.isEmpty() && count < list.size()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                size--;
                if (node == null) {
                    count += 2;
                    queue.offer(null);
                    queue.offer(null);
                    continue;
                }
                Integer val = list.get(count);
                if (val != null) {
                    node.left = new TreeNode(val);
                } else {
                    node.left = null;
                }
                queue.offer(node.left);
                count++;

                val = list.get(count);
                if (val != null) {
                    node.right = new TreeNode(val);
                } else {
                    node.right = null;
                }
                queue.offer(node.right);
                count++;
            }
        }
        return root;
    }

}
