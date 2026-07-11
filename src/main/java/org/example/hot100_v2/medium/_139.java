package org.example.hot100_v2.medium;

import java.util.*;

/**
 * @author kylin
 * @date 2026/7/11
 */

public class _139 {

    private Map<String, Boolean> memory = new HashMap<>();

    public boolean wordBreakReverse(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return true;
        }
        if (memory.containsKey(s)) {
            return memory.get(s);
        }

        List<String> prefixList = new ArrayList<>();
        for (String sub : wordDict) {
            if (s.startsWith(sub)) {
                prefixList.add(sub);
            }
        }
        if (!prefixList.isEmpty()) {
            for (String prefix : prefixList) {
                String subStr = s.substring(prefix.length());
                if (wordBreakReverse(subStr, wordDict)) {
                    memory.put(subStr, true);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
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
        System.out.println(obj.wordBreakReverse("leetcode", Arrays.asList("leet", "code"))); // true
        System.out.println(obj.wordBreakReverse("abcd", Arrays.asList("a","abc","b","cd"))); // true
        System.out.println(obj.wordBreakReverse("catsandog", Arrays.asList("cats","dog","sand","and","cat"))); // false
    }

}
