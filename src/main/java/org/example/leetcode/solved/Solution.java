package org.example.leetcode.solved;

import java.util.*;

public class Solution {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode next;

        TreeNode(int x) {
            val = x;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }



    public static void main(String[] args) {

//        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(9);
//        root.right = new TreeNode(20);
//        root.left.left = new TreeNode(5);
//        root.left.right = new TreeNode(11);
//        root.right.left = new TreeNode(15);
//        root.right.right = new TreeNode(17);

//        int[][] A = new int[5][5];
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 5; j++) {
//                A[i][j] = i * 5 + j + 1;
//                System.out.print(A[i][j] + " ");
//            }
//            System.out.println();
//        }
//
//        ArrayList<Integer> matrix = spiralOrder(A);
//
//        for (Integer i : matrix) {
//            System.out.print(i + " ");
//        }
//        int[][] A = generateMatrix(4);
//        for (int i = 0; i < A.length; i++) {
//            for (int j = 0; j < A.length; j++) {
//                System.out.print(A[i][j] + " ");
//            }
//            System.out.println();
//        }

//        int[] A = {-2,1};
//        int[] A = {-3,-2,-1};
//        int[] A = {-2,1,-3,4,-1,2,1,-5,4};
//        int max = maxSubArray_dp(A);
//        System.out.println(max);
//        int[][] matrix = new int[5][5];
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 5; j++) {
//                matrix[i][j] = i * 5 + j + 1;
//                System.out.print(matrix[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();
//        rotate(matrix);
//
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 5; j++) {
//                System.out.print(matrix[i][j] + " ");
//            }
//            System.out.println();
//        }
//        int[] nums = {3,2,2,3};
//        int[] nums = {0,1,2,2,3,0,4,2};
        int[] nums = {2};
        int n = removeElement(nums, 2);
        System.out.println(n);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }

    }


    public static int singleNumber(int[] A) {
        int n = A[0];
        for (int i = 1; i < A.length; i++) {
            n = n ^ A[i];
        }
        return n;
    }

    public static int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        else {
            int l_Height = maxDepth(root.left);
            int r_Height = maxDepth(root.right);
            return Math.max(l_Height, r_Height) + 1;
        }
    }

    //
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        else {
            return false;
        }
    }

    // 求给定的二叉树的前序遍历。
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();

        TreeNode node = root;

        stack.push(node);

        while (!stack.isEmpty()) {
            node = stack.pop();
            list.add(node.val);
            // 右节点先入栈，左节点在右节点上面
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }

        return list;
    }

    // 判断链表是否有环
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            } else {
                slow = slow.next; // 慢指针走一步
                fast = fast.next.next; // 快指针走两步
            }
        }
        return true;
    }

    // 股票买卖 i
    public int maxProfit_i(int[] prices) {
        int min_price = Integer.MAX_VALUE;
        int max_profit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min_price)
                min_price = prices[i];
            else if (prices[i] - min_price > max_profit)
                max_profit = prices[i] - min_price;
        }

        return max_profit;
    }

    // 股票买卖 ii
    public int maxProfit_ii(int[] prices) {
        int max_profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                max_profit += prices[i] - prices[i - 1];
        }
        return max_profit;
    }

    // 填充每个节点的下一个右侧节点指针（层序遍历版）
    public void connect(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode node = root;
        TreeNode next_node = root;
        queue.add(node);
        while (!queue.isEmpty()) {
            // 记录每层的节点数量
            int levelSum = queue.size();
            for (int i = 0; i < levelSum; i++) {
                node = queue.remove();
                next_node = queue.peek();
                if (i == levelSum - 1)
                    node.next = null;
                else
                    node.next = next_node;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
    }

    // 填充每个节点的下一个右侧节点指针（递归版）
    public void connect_iter(TreeNode root) {
        if (root == null) {
            return;
        }
        if(root.left != null)
            root.left.next = root.right;
        if(root.right != null)
            root.right.next = root.next != null ? root.next.left : null;
        connect_iter(root.left);
        connect_iter(root.right);
    }

    // 递归获取树最大深度
    public int TreeDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(TreeDepth(root.left), TreeDepth(root.right)) + 1;
    }

    // 判断给定的二叉树是否是平衡的
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(TreeDepth(root.left) - TreeDepth(root.right)) < 2
                && isBalanced(root.left) && isBalanced(root.right);
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val)
                current.next = current.next.next;
            else
                current = current.next;
        }
        return head;
    }

    public void swap(int[] A, int a, int b) {
        int tmp = A[a];
        A[a] = A[b];
        A[b] = tmp;
    }

    public void sortColors(int[] nums) {
        int p0 = 0;
        int curr = 0;
        int p2 = nums.length - 1;

        while (curr <= p2) {
            if (nums[curr] == 0) {
                swap(nums, curr, p0);
                p0++;
                curr++;
            }
            else if (nums[curr] == 2) {
                swap(nums, curr, p2);
                p2--;
            }
            else {
                curr++;
            }
        }
    }


    public void setZeroes_i(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;
        Set<Integer> rows = new HashSet<Integer>();
        Set<Integer> cols = new HashSet<Integer>();

        // Essentially, we mark the rows and columns that are to be made zero
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        // Iterate over the array once again and using the rows and cols sets, update the elements.
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (rows.contains(i) || cols.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }

    }

    public void setZeroes_ii(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;

        int MODIFIED = -1000000;
        

        // Essentially, we mark the rows and columns that are to be made zero
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (matrix[r][c] == 0) {
                    // 行置为一个虚拟值
                    for (int k = 0; k < C; k++) {
                        if (matrix[r][k] != 0) {
                            matrix[r][k] = MODIFIED;
                        }
                    }
                    // 列置为一个虚拟值
                    for (int k = 0; k < R; k++) {
                        if (matrix[k][c] != 0) {
                            matrix[k][c] = MODIFIED;
                        }
                    }
                }
            }
        }

        // Iterate over the array once again and using the rows and cols sets, update the elements.
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (matrix[i][j] == MODIFIED) {
                    matrix[i][j] = 0;
                }
            }
        }

    }

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            }
            else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 直到l1或l2有一个为空
        if (l1 == null) {
            prev.next = l2;
        }
        else {
            prev.next = l1;
        }
        return prehead.next;
    }

    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];

        for (int i = 0; i < n; i++) dp[0][i] = 1;
        for (int i = 0; i < m; i++) dp[i][0] = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    public static ArrayList<Integer> spiralOrder(int[][] matrix) {

        ArrayList<Integer> res = new ArrayList<>();

        int R = matrix.length;

        if (R == 0)
            return res;

        int C = matrix[0].length;

        int r_min = 0;
        int r_max = R - 1;
        int c_min = 0;
        int c_max = C - 1;

        while (true) {
            for (int i = c_min; i <= c_max; i++)
                res.add(matrix[r_min][i]);

            if (r_min < r_max)
                r_min++;
            else
                break;

            for (int j = r_min; j <= r_max; j++)
                res.add(matrix[j][c_max]);

            if (c_min < c_max)
                c_max--;
            else
                break;

            for (int i = c_max; i >= c_min; i--)
                res.add(matrix[r_max][i]);

            if (r_min < r_max)
                r_max--;
            else
                break;

            for (int j = r_max; j >= r_min; j--)
                res.add(matrix[j][c_min]);

            if (c_min < c_max)
                c_min++;
            else
                break;

        }
        return res;
    }

    public static int[][] generateMatrix(int n) {

        int[][] matrix = new int[n][n];

        int r_min = 0;
        int r_max = n - 1;
        int c_min = 0;
        int c_max = n - 1;

        int count = 0;
        while (true) {
            for (int i = c_min; i <= c_max; i++)
                matrix[r_min][i] = ++count;

            if (r_min < r_max)
                r_min++;
            else
                break;

            for (int j = r_min; j <= r_max; j++)
                matrix[j][c_max] = ++count;

            if (c_min < c_max)
                c_max--;
            else
                break;

            for (int i = c_max; i >= c_min; i--)
                matrix[r_max][i] = ++count;

            if (r_min < r_max)
                r_max--;
            else
                break;

            for (int j = r_max; j >= r_min; j--)
                matrix[j][c_min] = ++count;

            if (c_min < c_max)
                c_min++;
            else
                break;

        }
        return matrix;
    }

    public static int maxSubArray(int[] A) {
        int max = A[0];
        int cur = A[0];
        for (int i = 1; i < A.length; i++) {
            cur = Math.max(A[i], cur + A[i]);
            max = Math.max(max, cur);

        }
        return max;
    }

    public static int maxSubArray_dp(int[] A) {

        int[] dp = new int[A.length];
        dp[0] = A[0];

        for (int i = 1; i < A.length; i++) {
                dp[i] = Math.max(dp[i - 1] + A[i], A[i]);
        }

        // 取dp数组中的最大值
        int max = A[0];
        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i] + " ");
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void rotate(int[][] matrix) {
        int R = matrix.length - 1;
        int C = matrix[0].length - 1;

        int layer = (R + 1) / 2; // 计算需要操作的层数

        for (int i = 0; i < layer; i++) {
            int begin = i;
            int end = C - i;
            int tmp = 0; // 暂存值
            for (int n = 0; n < end - begin; n++) {
                tmp = matrix[i][begin + n]; // 记下左上角的值
                // 左上角 <- 左下角
                matrix[i][begin + n] = matrix[end - n][i];
                // 左下角 <- 右下角
                matrix[end - n][i] = matrix[R - i][end - n];
                // 右下角 <- 右上角
                matrix[R - i][end - n] = matrix[begin + n][C - i];
                // 右上角 <- 原始左上角
                matrix[begin + n][C - i] = tmp;
            }

        }
    }

    public static int removeElement(int[] nums, int val) {

        if (nums.length <= 0) {
            return 0;
        }
        else if (nums.length == 1) {
            if (nums[0] == val) return 0;
            else return 1;
        }

        int right = nums.length - 1;
        int count = 0;
        int tmp = 0;

        for (int i = 0; i < nums.length / 2 + 1; i++) {
            if (nums[i] == val) {
                while (nums[right] == val && right > i) {
                    count++;
                    right--;
                }
                tmp = nums[i];
                nums[i] = nums[right];
                nums[right] = tmp;
                count++;
                right--;
            }
        }

        return nums.length - count;
    }

}
