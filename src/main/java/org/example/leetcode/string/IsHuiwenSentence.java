package org.example.leetcode.string;

public class IsHuiwenSentence {
    /*
    125. 回文串
    考虑字母和数字字符。空字符串定义为有效的回文串。

    示例 1:

    输入: "A man, a plan, a canal: Panama"
    输出: true

    只
     */
    public static boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (Character.isLetterOrDigit(cur))
                sb.append(Character.toLowerCase(cur));
        }
        String raw = sb.toString();

        return raw.equals(sb.reverse().toString());
    }

    public static void main(String[] args) {
//        isPalindrome("A man, a plan, a canal: Panama");
        isPalindrome("race a car");
    }
}
