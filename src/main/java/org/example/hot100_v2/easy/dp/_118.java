package org.example.hot100_v2.easy.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 输入n，生成n行的杨辉三角（在「杨辉三角」中，每个数是它左上方和右上方的数的和。 ）
 * @author kylin
 * @date 2026/7/18
 */

public class _118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.asList(1));
        for (int i = 2; i <= numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) {
                    temp.add(1);
                } else {
                    // dp
                    temp.add(res.get(i - 2).get(j - 1) + res.get(i - 2).get(j));
                }
            }
            res.add(temp);
        }
        return res;
    }

    public static void main(String[] args) {
        _118 obj = new _118();
        System.out.println(obj.generate(4).toString());
    }
}
