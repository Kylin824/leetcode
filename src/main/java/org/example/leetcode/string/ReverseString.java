package org.example.leetcode.string;

public class ReverseString {
    public void reverseString(char[] s) {
        char tmp;
        for (int i = 0; i < s.length / 2 - 1; i++) {
            tmp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = tmp;
        }
    }
}
