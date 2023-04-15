package org.example.hot100.string;

import org.apache.flink.streaming.api.operators.UdfStreamOperatorFactory;

public class _5 {

    public static void main(String[] args) {
        _5 o = new _5();
//        System.out.println(o.longestPalindrome("aabac"));
        System.out.println(o.longestPalindrome1("aabac"));
    }

    int maxStart = 0;
    int maxEnd = 0;
    int maxLen = 0;

    // 双指针 中心扩散
    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            countSubstrings(s, i, i);
            countSubstrings(s, i, i + 1);
        }
        return s.substring(maxStart, maxEnd + 1);
    }

    public void countSubstrings(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            if (end - start > maxLen) {
                maxLen = end - start;
                maxStart = start;
                maxEnd = end;
            }
            start--;
            end++;
        }

    }

    // 动态规划 同_647
    public String longestPalindrome1(String s) {

        int maxStart = 0, maxEnd = 0, maxLen = 1;

        boolean dp[][] = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (i == j) {
                    dp[i][j] = true;
                } else if (i == j + 1 && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    if (maxLen == 1) {
                        maxLen = 2;
                        maxStart = j;
                        maxEnd = i;
                    }
                } else if (dp[i - 1][j + 1] && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    if (i - j + 1 > maxLen) {
                        maxLen = i - j + 1;
                        maxStart = j;
                        maxEnd = i;
                    }
                }
            }
        }

        return s.substring(maxStart, maxEnd + 1);
    }


}
