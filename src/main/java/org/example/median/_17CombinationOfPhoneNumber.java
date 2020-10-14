package org.example.median;

import java.util.ArrayList;
import java.util.List;

public class _17CombinationOfPhoneNumber {
    /*
    17. 电话号码的字母组合
    给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
    给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

    思路：
        dfs+回溯   排列组合
     */
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }
        char[][] chars = {{'x'}, {'x'}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'}
                , {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

        StringBuilder path = new StringBuilder();
        dfs(digits, path, res, chars);
        return res;
    }

    public void dfs(String digits, StringBuilder path, List<String> res, char[][] chars) {
        if (digits.length() == 0) {
            res.add(path.toString());
            return;
        }
        int num = digits.charAt(0) - '0';
        for (int i = 0; i < chars[num].length; i++) {
            path.append(chars[num][i]);
            dfs(digits.substring(1), path, res, chars);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static void main(String[] args) {
        _17CombinationOfPhoneNumber cpn = new _17CombinationOfPhoneNumber();
        List<String> res = cpn.letterCombinations("23");
        for (String str : res) {
            System.out.println(str);
        }
    }
}

