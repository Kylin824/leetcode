package org.example.hot100.string;

public class _647 {

    /*

    给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。

    示例 1：
        输入：s = "abc"
        输出：3
        解释：三个回文子串: "a", "b", "c"

    示例 2：
        输入：s = "aaa"
        输出：6
        解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
     */

    public static void main(String[] args) {
        _647 o = new _647();
        System.out.println(o.countSubstrings1("aabc"));
    }

    // 双指针 中心扩散
    int res = 0;
    public int countSubstrings(String s) {
        if (s.length() <= 0) {
            return res;
        }
        for (int i = 0; i < s.length(); i++) {
            count(s, i, i);
            count(s, i, i + 1);
        }
        return res;
    }
    public void count(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            res++;
            start--;
            end++;
        }
    }


    /**
     * 动态规划
     *
     * dp[i][j] = {
     *     true      i == j
     *     true      i == j + 1 && s[i] == s[j]
     *     true      dp[i-1][j+1] && s[i] == s[j]
     * }
     */
    public int countSubstrings1(String s) {
        if (s.length() <= 0) {
            return res;
        }
        boolean dp[][] = new boolean[s.length()][s.length()];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (i == j) {
                    count++;
                    dp[i][j] = true;
                } else if (j + 1 == i && s.charAt(i) == s.charAt(j)){
                    count++;
                    dp[i][j] = true;
                } else if (s.charAt(i) == s.charAt(j) && dp[i - 1][j + 1]) {
                    count++;
                    dp[i][j] =true;
                }
            }
        }
        return count;
    }
}
