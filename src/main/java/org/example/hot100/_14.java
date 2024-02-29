package org.example.hot100;

//编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。
//
//
//
// 示例 1：
//
//
//输入：strs = ["flower","flow","flight"]
//输出："fl"
//
//
// 示例 2：
//
//
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。
//
//
//
// 提示：
//
//
// 1 <= strs.length <= 200
// 0 <= strs[i].length <= 200
// strs[i] 仅由小写英文字母组成
//
//
// Related Topics 字典树 字符串 👍 3065 👎 0

public class _14 {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int minLen = Integer.MAX_VALUE;
        for (String str : strs) {
            minLen = Math.min(str.length(), minLen);
        }
        for (int i = 0; i < minLen; i++) {
            boolean f = true;
            char c = strs[0].charAt(i);
            for (String str : strs) {
                if (str.charAt(i) != c) {
                    f = false;
                    break;
                }
            }
            if (f) {
                sb.append(c);
            } else {
                break;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        _14 a = new _14();
        System.out.println(a.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));;
    }
}
