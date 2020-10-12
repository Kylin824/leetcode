package org.example.median;

import java.util.HashMap;

public class _3LongestNoRepeatSubString {
    /*
    3. 无重复字符的最长子串
    给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

    示例 1:
    输入: "abcabcbb"
    输出: 3
    解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

    示例 2:
    输入: "bbbbb"
    输出: 1
    解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。

    思路:
        滑动窗口
        关键是更新窗口左索引，根据当前位置到左窗口索引得到长度
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int windowLeft = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), i); // 记录第一次出现的位置
            }
            else {
                windowLeft = Math.max(windowLeft, map.get(s.charAt(i)) + 1);
                map.put(s.charAt(i), i); // 更新字符的新位置
            }
            int currentLength = i - windowLeft + 1; // 当前窗口长度
            max = Math.max(currentLength, max);
        }
        return max;
    }
}
