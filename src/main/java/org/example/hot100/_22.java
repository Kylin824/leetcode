package org.example.hot100;

import java.util.ArrayList;
import java.util.List;

//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
//
//
// 示例 1：
//
//
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
//
//
// 示例 2：
//
//
//输入：n = 1
//输出：["()"]
//
//
//
//
// 提示：
//
//
// 1 <= n <= 8
//
//
// Related Topics 字符串 动态规划 回溯 👍 3524 👎 0

public class _22 {

    public static List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();

        if (n <= 0) {
            return res;
        }

        dfs("", res, n, n);

        return res;

    }

    // 回溯 + 剪枝  深度优先遍历
    public static void dfs(String curStr, List<String> res, int left, int right) {

        if (left == 0 && right == 0) {
            res.add(curStr);
            return;
        }

        if (left > right) {
            return;
        }

        if (left > 0) {
            dfs(curStr + "(", res, left - 1, right);
        }

        if (right > 0) {
            dfs(curStr + ")", res, left, right - 1);
        }
    }
}
