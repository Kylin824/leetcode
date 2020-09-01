package org.example.interview.string;

public class IsCharUnique {
    /*
    面试题 01.01. 判定字符是否唯一
    实现一个算法，确定一个字符串 s 的所有字符是否全都不同。

    1.使用map看有没有次数超过1
    2.使用set存入，看set的大小是否等于原长度
    3.indexOf() lastIndexOf()
    4.双重循环暴力
    5.ASCII码共128个，使用位图来代替map

     */
    public boolean isUnique(String astr) {
        int[] map = new int[256];
        for (int i = 0; i < astr.length(); i++) {
            map[astr.charAt(i)]++;
        }
        for (int i : map) {
            if (i > 1) {
                return false;
            }
        }
        return true;
    }

    public boolean isUnique1(String astr) {
        for (int i = 0; i < astr.length(); i++) {
            char ch = astr.charAt(i);
            if (astr.indexOf(ch) != astr.lastIndexOf(ch)) {
                return false;
            }
        }
        return true;
    }
}
