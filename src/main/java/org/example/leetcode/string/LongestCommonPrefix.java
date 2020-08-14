package org.example.leetcode.string;

public class LongestCommonPrefix {

    /*
    14. 编写一个函数来查找字符串数组中的最长公共前缀。

    如果不存在公共前缀，返回空字符串 ""。

    示例 1:

    输入: ["flower","flow","flight"]
    输出: "fl"
     */

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length <= 0) {
            return "";
        }
        String ans = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (; j < strs[i].length() && j < ans.length(); j++) {
                if (ans.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            ans = ans.substring(0, j);
            if ("".equals(ans)) {
                return "";
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] strs = {"","b"};
        System.out.println(longestCommonPrefix(strs));
    }
}
