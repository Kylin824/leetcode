package org.example.leetcode;

public class HuiwenNum {
    /*
        LC140 在不使用额外的内存空间的条件下判断一个整数是否是回文
     */
    /*
        思路 转字符串
     */

    public static boolean isPalindrome (int x) {
        // write code here
        if (x < 0) return false;
        String str = String.valueOf(x);
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return str.equals(sb.toString());
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(0));
    }
}
