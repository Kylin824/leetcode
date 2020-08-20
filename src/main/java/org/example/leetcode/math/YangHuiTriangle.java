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

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        if (numRows <= 0)
            return ret;
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        ret.add(firstRow);
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < i; j++) {
                
            }
        }
        
        return ret;
    }
}
