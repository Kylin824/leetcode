package org.example.hot100_v2.easy;

/**
 * @author kylin
 * @date 2026/7/13
 */
public class _14 {

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder res =  new StringBuilder();
        int len = Integer.MAX_VALUE;
        for (String str : strs) {
            len = Math.min(len, str.length());
        }
        for (int i = 0; i < len; i++) {
            char ch = strs[0].charAt(i);
            for (String str : strs) {
                if (ch != str.charAt(i)) {
                    return res.toString();
                }
            }
            res.append(ch);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }
}
