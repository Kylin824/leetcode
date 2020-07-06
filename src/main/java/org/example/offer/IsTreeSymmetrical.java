package org.example.offer;

public class IsTreeSymmetrical {
    /*
        NO.58
        判断一棵二叉树是不是对称的。
     */
    /*
        思路:
            递归
                         1
                       /  \
                      2    2
                     / \  / \
                    3  4 4  3
     */
    boolean isSymmetrical(TreeNode pRoot)
    {
        return isSame(pRoot, pRoot);
    }

    boolean isSame(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        return root1.val == root2.val && isSame(root1.left, root2.right) && isSame(root1.right, root2.left);
    }
}
