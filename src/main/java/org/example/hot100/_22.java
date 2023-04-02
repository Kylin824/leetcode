package org.example.hot100;

import java.util.ArrayList;
import java.util.List;

public class _22 {


    public static void main(String[] args) {

    }

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
