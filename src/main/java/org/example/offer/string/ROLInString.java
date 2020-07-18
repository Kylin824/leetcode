package org.example.offer.string;

import java.util.Arrays;

public class ROLInString {
    /*
        NO.43
        对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
        例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
     */
    /*
        思路:
            1. api: String.substring(begin, end)

            2. 自己实现substring, 实际上substring()是通过字符数组的Arrays.copyOfRange()实现的
     */
    public static String LeftRotateString(String str,int n) {
        if (n == 0 || str.length() <= 0)
            return str;
        String left = str.substring(0, n);
        String right = str.substring(n);
        return right + left;

    }

    public static String LeftRotateString1(String str, int n) {
        if (n == 0 || str.length() <= 0)
            return str;
        char[] left = Arrays.copyOfRange(str.toCharArray(), 0, n);
        char[] right = Arrays.copyOfRange(str.toCharArray(), n, str.length());
        return String.valueOf(right) + String.valueOf(left);
    }

    public static void main(String[] args) {
        String str = "hello";
        String str1 = str.substring(0, str.length() - 1);
        String right = str.substring(str.length() - 1, str.length());
        System.out.println(right);
        String ret =LeftRotateString1(str, 3);
        System.out.println(ret);
    }
}
