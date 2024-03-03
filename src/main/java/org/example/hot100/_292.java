package org.example.hot100;


//你和你的朋友，两个人一起玩 Nim 游戏：
//
//
// 桌子上有一堆石头。
// 你们轮流进行自己的回合， 你作为先手 。
// 每一回合，轮到的人拿掉 1 - 3 块石头。
// 拿掉最后一块石头的人就是获胜者。
//
//
// 假设你们每一步都是最优解。请编写一个函数，来判断你是否可以在给定石头数量为 n 的情况下赢得游戏。如果可以赢，返回 true；否则，返回 false 。
//
//
//
//
// 示例 1：
//
//
//输入：n = 4
//输出：false
//解释：以下是可能的结果:
//1. 移除1颗石头。你的朋友移走了3块石头，包括最后一块。你的朋友赢了。
//2. 移除2个石子。你的朋友移走2块石头，包括最后一块。你的朋友赢了。
//3.你移走3颗石子。你的朋友移走了最后一块石头。你的朋友赢了。
//在所有结果中，你的朋友是赢家。
//
//
// 示例 2：
//
//
//输入：n = 1
//输出：true
//
//
// 示例 3：
//
//
//输入：n = 2
//输出：true
//
//
//
//
// 提示：
//
//
// 1 <= n <= 2³¹ - 1
//
//
// Related Topics 脑筋急转弯 数学 博弈 👍 759 👎 0

public class _292 {

    // 递归解法
    public boolean canWinNim(int n) {
        if (n == 1 || n == 2 || n == 3) {
            return true;
        }
        if (n == 4) {
            return false;
        }
        return !(canWinNim(n - 1) & canWinNim(n - 2) & canWinNim(n - 3));
    }

    // dp解法
    public boolean canWinNim1(int n) {
        if (n <= 3) {
            return true;
        }
        if (n == 4) {
            return false;
        }
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        dp[1] = true;
        dp[2] = true;
        dp[3] = true;
        dp[4] = false;
        for (int i = 5; i <= n; i++) {
            dp[i] = !(dp[i - 1] & dp[i - 2] & dp[i - 3]);
        }
        return dp[n];
    }

    // dp矩阵中发现实际上只要是4的倍数就是false，其他都是true
    public boolean canWinNim2(int n) {
        return n % 4 != 0;
    }


    public static void main(String[] args) {
        _292 a = new _292();
        System.out.println(a.canWinNim1(1)); // true
        System.out.println(a.canWinNim1(4)); // false
        System.out.println(a.canWinNim1(5)); // true
        System.out.println(a.canWinNim1(8)); // false
        System.out.println(a.canWinNim1(10)); // true
        System.out.println(a.canWinNim1(1348820612)); // false
    }

}
