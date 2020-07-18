package org.example.offer.array;

import java.util.ArrayList;

public class PrintMatrixClockwise {
    /*
        NO.19
        输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
        例如，4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
        则依次打印出数字 1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
     */
    /*
        思路:
            注意矩阵不是 nxn 而是 nxm的
            1. 左上角和右下角定位出最外围的圈
            2. 依次打印每个圈的上下左右四行，当圈只有一行或一列时不需要打印下和左
            3. 往里面进一圈
     */
    // 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
    //注意：保证测试中不会当栈为空的时候，对栈调用pop()或者min()或者top()方法。

    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();

        int r = matrix.length - 1; // r行
        int c = matrix[0].length - 1; // c列

        int lr = 0, lc = 0;
        int rr = r, rc = c;

        while (rr >= lr && rc >= lc) {

            // up
            for (int i = lc; i <= rc; i++) {
                res.add(matrix[lr][i]);
            }

            // right
            for (int i = lr + 1; i <= rr; i++) {
                res.add(matrix[i][rc]);
            }

            // 只有一行时不需要打印最下面一行
            int h = rr - lr + 1;
            if (h > 1) {
                // down
                for (int i = rc - 1; i >= lc; i--) {
                    res.add(matrix[rr][i]);
                }
            }
            // 只有一列时不需要打印最左边一行
            int w = rc - lc + 1;
            if (w > 1) {
                // left
                for (int i = rr - 1; i >= lr + 1 ; i--) {
                    res.add(matrix[i][lc]);
                }
            }
            lr++;
            lc++;
            rr--;
            rc--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
//        int[][] matrix = {{1, 2, 3, 4}};
//        int[][] matrix = {{1}};
//        int[][] matrix = {{1},{2},{3},{4}};
//        int[][] matrix = {{1,2},{3,4}};
        ArrayList<Integer> res = printMatrix(matrix);
        for (Integer i : res) {
            System.out.print(i + " ");
        }
    }
}
