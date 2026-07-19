package org.example.hot100_v2.medium.backtrack;

import java.util.ArrayList;
import java.util.List;

public class _131 {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        backtrack(s, 0, path, res);
        return res;
    }

    public void backtrack(String s, int index, List<String> path, List<List<String>> res) {
        if (index == s.length()) {
            res.add(new ArrayList<>(path));
        }
        for (int i = index; i < s.length(); i++) {
            if (!isPalindrome(s, index, i)) {
                continue;
            }
            path.add(s.substring(index, i + 1));
            backtrack(s, i + 1, path, res);

            // 撤回选择，尝试下一个index
            path.remove(path.size() - 1);
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        _131 a = new _131();
        System.out.println(a.partition("aab").toString());
    }
}
