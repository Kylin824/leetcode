package org.example.hot100_v2.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author kylin
 * @date 2026/7/10
 */

public class _17 {

    List<String> res = new ArrayList<>();

    HashMap<Character, String> map = new HashMap<Character, String>() {
        {
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }
    };

    public List<String> letterCombinations(String digits) {
        backtrack(digits, "", 0);
        return res;
    }

    public void backtrack(String digits, String s, Integer i) {
        if (i == digits.length()) {
            res.add(s);
            return;
        }
        char ch = digits.charAt(i); // 第i位数字
        String str = map.get(ch); // 对应的字符
        for (int j = 0; j < str.length(); j++) {
            backtrack(digits, s + str.charAt(j), i + 1);
        }
    }

    public static void main(String[] args) {
        _17 obj = new _17();
        System.out.println(obj.letterCombinations("23"));
    }

}
