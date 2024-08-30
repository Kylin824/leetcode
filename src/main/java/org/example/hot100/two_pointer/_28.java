package org.example.hot100.two_pointer;

/**
* @author kylin
* @date 2024/8/30
*/public class _28 {

    public int strStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length(); i++) {
            if (i + needle.length() > haystack.length()) {
                return -1;
            }
            if (needle.equals(haystack.substring(i, i + needle.length()))) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        _28 c = new _28();
        System.out.println(c.strStr("leetcode", "etca"));
    }
}
