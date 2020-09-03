package org.example.interview.string;

public class CanBeHuiWen {
    /*
    面试题 01.04. 回文排列
    给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。

    思路：有且只有一个字符出现的次数为奇数时
     */
    public static boolean canPermutePalindrome(String s) {
        char[] chars = s.toCharArray();
        char[] map = new char[128];
        for (int i = 0; i < chars.length; i++) {
            map[chars[i]]++;
        }
        int count = 0; // 统计奇数次数的字符
        for (int i = 0; i < map.length; i++) {
            if (map[i] % 2 != 0) { // 字符出现次数为奇数
                count++;
            }
            if (count > 1) { // 奇数次字符超过1个，则无法组成回文
                return false;
            }
        }
        return true;
    }

    public static boolean canPermutePalindromeOpt(String s) {
        int count = 0;
        char[] map = new char[128];
        for (char c : s.toCharArray()) {
            if ((map[c]++ % 2) != 0) { // 出现奇数次
                count--;
            } else {
                count++;
            }
        }
        return count <= 1;
    }
}
