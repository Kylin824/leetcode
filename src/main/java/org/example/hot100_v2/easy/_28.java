package org.example.hot100_v2.easy;

/**
 * @author kylin
 * @date 2026/7/13
 */

public class _28 {
    public static int strStr(String haystack, String needle) {
        if(haystack.length() < needle.length()) {
            return -1;
        }
        for (int i = 0; i < haystack.length(); i++) {
            char ch = haystack.charAt(i);
            if (ch == needle.charAt(0)) {
                boolean match = true;
                for (int j = 0; j < needle.length(); j++) {
                    if (j + i >= haystack.length()) {
                        match = false;
                        break;
                    } else if (needle.charAt(j) != haystack.charAt(i + j)) {
                        match = false;
                    }
                }
                if (match) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String h = "mississippi";
        String n = "sippi";
        System.out.println(strStr(h, n));
    }
}
