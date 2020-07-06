package org.example.offer;

public class IsStringMeansNum {
    /*
        NO.53
        请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
        例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
        但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
     */
    /*
        思路:
            -123.45e-67 -> true
            注意 : -.123 -> true
            1. 符号 +/- 前面必须为第一位 或者 前面必须为e或E 后面必须为数字或者.
            2. 符号  .  后面必须为数字 或者 为最后一位  并且只能出现一次
            2. 符号  e  后面必须为符号或数字
     */

    public static boolean isNumeric(char[] str) {

        boolean point = false, exp = false;

        for (int i = 0; i < str.length; i++) {
            if (str[i] == '+' || str[i] == '-') {
                // 符号只能出现在第一位或者e后面第一位
                if (!(i == 0 || str[i-1] == 'e' || str[i-1] == 'E')) {
                    return false;
                }
                // 符号后面必定为数字或者.
                if (i + 1 == str.length || !(str[i+1] >= '0' && str[i+1] <= '9' || str[i+1] == '.')) { //
                    return false;
                }
            }
            else if (str[i] == '.') {
                // .的后面必定为数字，或者为最后一位
                if (point || exp || !(i + 1 < str.length && str[i+1] >= '0' && str[i+1] <= '9')) {
                    return false;
                }
                point = true; // 标记.已出现
            }
            else if (str[i] == 'e' || str[i] == 'E') {
                if (exp || i+1 == str.length || !(str[i+1] >= '0' && str[i+1] <= '9' || str[i+1] == '+' || str[i+1] == '-')) {
                    return false;
                }
                exp = true;
            }
            else if (!(str[i] >= '0' && str[i] <= '9')) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isNumeric("100".toCharArray()));
    }
}
