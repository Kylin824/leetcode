package org.example.offer;

public class PatternMatcher {
    /*
        NO.52
        请实现一个函数用来匹配包括'.'和'*'的正则表达式。
        模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
        在本题中，匹配是指字符串的所有字符匹配整个模式。
        例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
     */
    /*
        思路:
            1. 特殊情况:
                1) 两个字符串都为空 return true
                2) str不空 pattern空 return false;
                3) str空 pattern不空, 有可能true (因为*可以出现0次)
            匹配第一个字符, 同时要考虑下一个字符是否为'*'
                1)下一个字符不为'*', 直接匹配当前字符
                2)下一个字符为'*'时
                    a.
     */
    public static boolean match(char[] str, char[] pattern) {
        return matchStr(str, 0, pattern, 0);
    }
    public static boolean matchStr(char[] str, int i, char[] pattern, int j) {
        if (i == str.length && j == pattern.length)
            return true;
        else if (j == pattern.length)
            return false;

        if (j + 1 < pattern.length &&  pattern[j + 1] == '*') {
            if (i < str.length && (pattern[j] == '.' || str[i] == pattern[j]))
                return matchStr(str, i, pattern, j+2) || matchStr(str, i+1, pattern, j);
            else
                return matchStr(str, i, pattern, j+2);
        }
        else {
            // 下一个字符不为'*'
            if (i < str.length && (pattern[j] == '.' || str[i] == pattern[j]))
                return matchStr(str, i+1, pattern, j+1);
            else
                return false;
        }
    }

    public static void main(String[] args) {

        System.out.println(match("a".toCharArray(), ".".toCharArray()));
    }
}
