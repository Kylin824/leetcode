package org.example.leetcode.math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class YangHuiTriangleII {
    /*
    119. 杨辉三角II

    给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。

    输入: 3
    输出: [1,3,3,1]


    更好的思路：建一个长度为rowIndex的全1数组， 从后往前计算rowIndex次
   */

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        if (rowIndex == 0) {
            return row;
        }
        row.add(1);
        if (rowIndex == 1) {
            return row;
        }
        List<Integer> newRow = new ArrayList<>();
        for (int i = 1; i <= rowIndex; i++) {
            newRow.add(1);
            for (int j = 1; j < i; j++) {
                newRow.add(row.get(j - 1) + row.get(j));
            }
            newRow.add(1);
            row = new ArrayList<>(newRow);
            newRow.clear();
        }
        return row;
    }

    public static void main(String[] args) {
        List<Integer> res = getRow(2);
        res.stream().forEach(x -> System.out.print(x + " "));
    }
}
