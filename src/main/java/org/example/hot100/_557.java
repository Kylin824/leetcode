package org.example.hot100;

//给定一个字符串
// s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
//
//
//
// 示例 1：
//
//
//输入：s = "Let's take LeetCode contest"
//输出："s'teL ekat edoCteeL tsetnoc"
//
//
// 示例 2:
//
//
//输入： s = "Mr Ding"
//输出："rM gniD"
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 5 * 10⁴
//
// s 包含可打印的 ASCII 字符。
//
// s 不包含任何开头或结尾空格。
//
// s 里 至少 有一个词。
//
// s 中的所有单词都用一个空格隔开。
//
//
// Related Topics 双指针 字符串 👍 578 👎 0


public class _557 {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = 0;
        while (i < s.length()) {
            while (j < s.length() && chars[j] != ' ') {
                j++;
            }
            if (i < j) {
                swap(chars, i, j - 1);
            }
            i = j + 1;
            j = i;
        }
        return new String(chars);
    }

    public void swap(char[] chars, int i, int j) {
        while (i < j) {
            char tmp =  chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        _557 a = new _557();
        System.out.println(a.reverseWords("Let's take LeetCode contest"));
    }
}
