package org.example.hot100.array;

import java.util.Arrays;

/**
 * @author kylin
 * @date 2024/8/31
 */
public class _242 {

    public static void main(String[] args) {
        System.out.println(_242.isAnagram("anagram", "nagaram"));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] ss = s.toCharArray();
        Arrays.sort(ss);
        char[] ts = t.toCharArray();
        Arrays.sort(ts);
        for (int i = 0; i < ss.length; i++) {
            if (ss[i] != ts[i]) {
                return false;
            }
        }
        return true;
    }

}
