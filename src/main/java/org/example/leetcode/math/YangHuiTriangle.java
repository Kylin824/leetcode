package org.example.leetcode.math;

import org.apache.spark.sql.execution.columnar.INT;

import java.util.ArrayList;
import java.util.List;

public class YangHuiTriangle {
    /*
    118. 杨辉三角
    输入: 5
    输出:
    [
         [1],
        [1,1],
       [1,2,1],
      [1,3,3,1],
     [1,4,6,4,1]
    ]
     */

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        if (numRows <= 0)
            return ret;
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        ret.add(firstRow);
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            List<Integer> lastRow = ret.get(i - 1);
            for (int j = 1; j < i; j++) {
                int cur = lastRow.get(j-1) + lastRow.get(j);
                row.add(cur);
            }
            row.add(1);
            ret.add(row);
        }

        for (int i = 0; i < ret.size(); i++) {
            List<Integer> row = ret.get(i);
            for (int j = 0; j < row.size(); j++) {
                System.out.print(row.get(j) + " ");
            }
            System.out.println();
        }
        return ret;
    }

    public static void main(String[] args) {
        List<List<Integer>> res = generate(5);
        System.out.println("test");
    }
}
