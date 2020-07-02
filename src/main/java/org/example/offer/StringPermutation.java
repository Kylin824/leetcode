package org.example.offer;

import java.util.ArrayList;
import java.util.TreeSet;

public class StringPermutation {
    /*
        NO.27
        输入一个字符串,按字典序打印出该字符串中字符的全排列。
        例如 abc,则全排列为 abc,acb,bac,bca,cab和cba。
     */
    /*
        思路:
            1. 递归并交换，思路巧妙
            // https://www.nowcoder.com/questionTerminal/fe6b651b66ae47d7acce78ffdd9a96c7?answerType=1&f=discussion

        tips:
            1. 转为chars[]方便交换字符串中的字符
            2. Treeset满足按字典序并去除重复的结果(abb,abb...)
            3. Set转为ArrayList: 作为ArrayList构造方法的参数传入
     */
    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str.length() <= 0)
            return res;
        TreeSet<String> set = new TreeSet<>();
        perm(0, str.toCharArray(), set);
        res = new ArrayList<>(set);
        return res;
    }

    public static void perm(int pos, char[] str, TreeSet<String> set) {
        if (pos == str.length - 1) {
            set.add(String.valueOf(str));
            return;
        }

        // for循环和swap的含义：对于“ABC”，
        // 第一次'A' 与 'A'交换，字符串为"ABC", pos为0， 相当于固定'A'
        // 第二次'A' 与 'B'交换，字符串为"BAC", pos为0， 相当于固定'B'
        // 第三次'A' 与 'C'交换，字符串为"CBA", pos为0， 相当于固定'C'
        for (int i = pos; i < str.length; i++) {
            swap(str, pos, i);
            perm(pos+1, str, set);
            swap(str, pos, i);
        }
    }

    public static void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    public static void main(String[] args) {
        ArrayList<String> res = Permutation("abc");
        for (String i : res) {
            System.out.println(i);
        }
    }

}
