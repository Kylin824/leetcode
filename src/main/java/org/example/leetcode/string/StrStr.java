package org.example.leetcode.string;

public class StrStr {

    /*
    28.实现 strStr()
    给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
    如果不存在，则返回  -1。

     */

    // quick solution
    // 单纯比较头超时   同时比较头尾
    // 正解是kmp

    public static int strStr(String haystack, String needle) {

        if  ("".equals(needle))
            return 0;
        if ("".equals(haystack))
            return -1;
        char first = needle.charAt(0);
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == first) {
                int last = needle.charAt(needle.length() - 1);
                if (i + needle.length() - 1 < haystack.length() && haystack.charAt(i + needle.length() - 1) == last) {
                    int h = i;
                    int n = 0;
                    while (h < haystack.length() && n < needle.length() && haystack.charAt(h) == needle.charAt(n)) {
                        h++;
                        n++;
                    }
                    if (n == needle.length()) {
                        return i;
                    }
                }

            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String h = "hello";
        String n = "ll";
        System.out.println(strStr(h, n));
        System.out.println("".length());
    }
}
