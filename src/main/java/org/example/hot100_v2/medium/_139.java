package org.example.hot100_v2.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kylin
 * @date 2026/7/11
 */

public class _139 {

    public boolean wordBreakReverse(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return true;
        }
        List<String> prefixList = new ArrayList<>();
        for (String sub : wordDict) {
            if (s.startsWith(sub)) {
                prefixList.add(sub);
            }
        }
        boolean res = false;
        if (!prefixList.isEmpty()) {
            for (String prefix : prefixList) {
                String subStr = s.substring(prefix.length());
                res |= wordBreakReverse(subStr, wordDict);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _139 obj = new _139();
        System.out.println(obj.wordBreakReverse("leetcode", Arrays.asList("leet", "code")));
        System.out.println(obj.wordBreakReverse("abcd", Arrays.asList("a","abc","b","cd")));
        System.out.println(obj.wordBreakReverse("catsandog", Arrays.asList("cats","dog","sand","and","cat")));
    }

}
