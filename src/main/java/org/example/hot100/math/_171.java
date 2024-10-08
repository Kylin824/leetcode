package org.example.hot100.math;

//给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回 该列名称对应的列序号 。
//
// 例如：
//
//
//A -> 1
//B -> 2
//C -> 3
//...
//Z -> 26
//AA -> 27
//AB -> 28
//...
//
//
//
// 示例 1:
//
//
//输入: columnTitle = "A"
//输出: 1
//
//
// 示例 2:
//
//
//输入: columnTitle = "AB"
//输出: 28
//
//
// 示例 3:
//
//
//输入: columnTitle = "ZY"
//输出: 701

public class _171 {

    public static void main(String[] args) {
        System.out.println(_171.titleToNumber("ZY"));;
    }

    public static int titleToNumber(String columnTitle) {
        int res = 0;
        int wei = 0;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            int c = columnTitle.charAt(i) - 'A' + 1;
            res += (int) (c * Math.pow(26, wei));
            wei++;
        }
        return res;
    }
}
