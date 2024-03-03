package org.example.hot100.dp;

//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
//
// 示例 1：
//
//输入：n = 2
//输出：2
//解释：有两种方法可以爬到楼顶。
//1. 1 阶 + 1 阶
//2. 2 阶
//
// 示例 2：
//
//输入：n = 3
//输出：3
//解释：有三种方法可以爬到楼顶。
//1. 1 阶 + 1 阶 + 1 阶
//2. 1 阶 + 2 阶
//3. 2 阶 + 1 阶
//
// 提示：
//
// 1 <= n <= 45
//
// Related Topics 记忆化搜索 数学 动态规划 👍 3450 👎 0

public class _70 {

    // dp[n]
    // 转移方程：dp[n] = dp[n−1] + dp[n−2]
    // 初始状态：dp[0] = 1; dp[1] = 1; dp[2] = 2;
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // dp[3]
    public int climbStairs1(int n) {
        if (n <= 3) {
            return n;
        }
        int r1 = 1;
        int r2 = 2;
        int r3 = 3;
        for (int i = 3; i <= n; i++) {
            r3 = r2 + r1;
            r1 = r2;
            r2 = r3;
        }
        return r3;
    }


    public static void main(String[] args) {
        _70 a = new _70();
        System.out.println(a.climbStairs1(4) + " " + a.climbStairs(4));
        System.out.println(a.climbStairs1(5) + " " + a.climbStairs(5));
        System.out.println(a.climbStairs1(6) + " " + a.climbStairs(6));
        System.out.println(a.climbStairs1(7) + " " + a.climbStairs(7));
    }

}
