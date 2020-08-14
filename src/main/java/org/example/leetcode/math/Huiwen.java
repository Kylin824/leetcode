package org.example.leetcode.math;

public class Huiwen {
    /*
    9. 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

    示例 1:
    输入: 121
    输出: true

    示例 2:
    输入: -121
    输出: false
    解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     */

    public static boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        StringBuilder sb = new StringBuilder(str).reverse();
        return str.equals(sb.toString());
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
    }
}
