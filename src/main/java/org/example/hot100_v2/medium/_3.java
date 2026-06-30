package org.example.hot100_v2.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 无重复字符的最长子串
 * @author kylin
 * @date 2026/6/30
 */

public class _3 {

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int p = 0, i = 0;
        Set<Character> set = new HashSet<>();

        int len = 0;
        while (p < s.length()) {
            char c = s.charAt(p);
            if (!set.contains(c)) {
                set.add(c);
                len++;
                p++;
            } else { // 遇到重复字符
                max = Math.max(max, len);
                set.clear();
                len = 0;
                i++;
                p = i;
            }
        }
        return Math.max(max, len);
    }
}
