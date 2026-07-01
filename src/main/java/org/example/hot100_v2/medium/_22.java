package org.example.hot100_v2.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * @author kylin
 * @date 2026/7/2
 */

public class _22 {

    public static List<String> generateParenthesis(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        List<List<String>> res = new ArrayList<>();

        List<String> s0 = new ArrayList<>();
        s0.add("");
        res.add(s0);

        List<String> s1 = new ArrayList<>();
        s1.add("()");
        res.add(s1);

        for (int i = 2; i <= n; i++) {
            Set<String> set = new HashSet<>();
            for (int j = 1; j <= i / 2; j++) {
                for (String ss1 : res.get(j)) {
                    for (String ss2 : res.get(i - j)) {
                        set.add(ss1 + ss2);
                        set.add(ss2 + ss1);
                    }
                }
                for (String ss3 : res.get(i - 1)) {
                    set.add("(" + ss3 + ")");
                }
            }
            List<String> si = new ArrayList<>();
            for (String s : set) {
                si.add(s);
            }
            res.add(si);
        }
        return res.get(n);
    }

    public static void main(String[] args) {
        generateParenthesis(4).forEach(System.out::println);
    }
}
