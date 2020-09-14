package org.example.leetcode.math;

public class ExcelSheetColumnTitle {
    /*
    168. Excel表列名称
    给定一个正整数，返回它在 Excel 表中相对应的列名称。
    例如，

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB
    ...

     */
    public static String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            n--; //
            sb.append((char)('A' + (n % 26)));
            n = n / 26;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(701));
    }
}
