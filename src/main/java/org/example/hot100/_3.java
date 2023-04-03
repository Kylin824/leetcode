package org.example.hot100;

import java.util.HashSet;
import java.util.Set;

public class _3 {

    // 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。

    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("abcabcbb"));

    }

    public static int lengthOfLongestSubstring(String s) {

        int max = 0;

        int i = 0, p = 0;

        int len = 0;

        Set<Character> set = new HashSet<>();

        while (p < s.length()) {
            char ch = s.charAt(p);
            if (!set.contains(ch)) {
                len++;
                set.add(ch);
                p++;
            } else {
                max = Math.max(len, max);
                set.clear();
                len = 0;
                p = i + 1;
                i = i + 1;
            }
        }

        return Math.max(len, max);
    }

    public static int lengthOfLongestSubstring1(String s) {

        int max = 0;

        int i = 0, p = 0;

        int len = 0;

        Set<Character> set = new HashSet<>();

        while (p < s.length()) {
            char ch = s.charAt(p);
            if (!set.contains(ch)) {
                len++;
                set.add(ch);
            } else {
                max = Math.max(len, max);
                while (i < p) {
                    if (s.charAt(i) == s.charAt(p)) {
                        i++;
                        break;
                    }
                    set.remove(s.charAt(i));
                    i++;
                    len--;
                }
            }
            p++;

        }

        return Math.max(len, max);
    }


}
