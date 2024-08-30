package org.example.hot100.dp;

import java.util.ArrayList;
import java.util.List;

//给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
//
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
//
//
//
//
//
// 示例 1:
//
//
//输入: numRows = 5
//输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
//
//
// 示例 2:
//
//
//输入: numRows = 1
//输出: [[1]]

public class _118 {

    public static void main(String[] args) {
        List<List<Integer>> res = _118.generate1(5);
        System.out.println(res);
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        res.add(firstRow); // 第一行
        for (int i = 2; i <= numRows; i++) {
            List<Integer> lastRow = res.get(i - 2);
            List<Integer> row = new ArrayList<>();
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i) {
                    row.add(1);
                } else {
                    row.add(lastRow.get(j - 2) + lastRow.get(j - 1));
                }
            }
            res.add(row);
        }
        return res;
    }

    public static List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        res.add(firstRow); // 第一行
        for (int i = 2; i <= numRows; i++) {
            List<Integer> row = generateRow(res.get(i - 2));
            res.add(row);
        }
        return res;
    }

    public static List<Integer> generateRow(List<Integer> lastRow) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        for (int i = 1; i < lastRow.size(); i++) {
            res.add(lastRow.get(i - 1) + lastRow.get(i));
        }
        res.add(1);
        return res;
    }
}
