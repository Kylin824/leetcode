package org.example.offer;

public class IsSubTree {
    /*
        NO.17
        输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
        {8,8,7,9,2,#,#,#,#,4,7},{8,9,2}
     */
    /*
        思路:
            1.递归：依次以A的每个节点为根节点，进行递归比较
            2.前/中/后序遍历两棵树得到字符串，转化成 判断 B子串是否在 A字符串中的问题
     */
    public static boolean dfs(TreeNode r1, TreeNode r2) {
        // 注意这里要先判断r2再判断r1
        if (r2 == null)
            return true;
        if (r1 == null)
            return false;
        return r1.val == r2.val && dfs(r1.left, r2.left) && dfs(r1.right, r2.right);
    }

    public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null)
            return false;
        return dfs(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(8);
        root1.left = new TreeNode(8);
        root1.left.left = new TreeNode(9);
        root1.left.right = new TreeNode(2);
        root1.left.right.left = new TreeNode(4);
        root1.left.right.right = new TreeNode(7);
        root1.right = new TreeNode(7);

        TreeNode root2 = new TreeNode(8);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(2);

        System.out.println(HasSubtree(root1, root2));

    }
}
