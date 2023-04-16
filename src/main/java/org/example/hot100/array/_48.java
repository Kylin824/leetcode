package org.example.hot100.array;

public class _48 {

    /*
     旋转图像

    给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。

    要求原地旋转
     */


    public static void main(String[] args) {
        _48 o = new _48();


        int[][] matrix = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

//        int[][] matrix = new int[][]{
//                {1,2},
//                {3,4}
//        };


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        o.rotate(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 递归方式
    public void rotate(int[][] matrix) {
        rotateCircle(matrix, 0, matrix.length - 1);
    }

    public void rotateCircle(int[][] matrix, int start, int end) {
        if (start >= end) {
            return;
        }

        for (int i = start; i < end; i++) {
            //  左上      matrix[start][i];
            //  右上      matrix[i][end];
            //  右下      matrix[end][start + end - i];
            //  左下      matrix[start + end - i][start];
            int tmp = matrix[start][i];
            matrix[start][i] = matrix[start + end - i][start]; // 左上 = 左下
            matrix[start + end - i][start] = matrix[end][start + end - i]; // 左下 = 右下
            matrix[end][start + end - i] = matrix[i][end]; // 右下 = 右上
            matrix[i][end] = tmp; // 右上 = 原左上
        }

        rotateCircle(matrix, start + 1, end - 1);
    }

}
