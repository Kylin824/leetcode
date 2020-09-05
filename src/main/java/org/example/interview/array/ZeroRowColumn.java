package org.example.interview.array;

public class ZeroRowColumn {
    /*
    面试题 01.08. 零矩阵
    编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
    */
    public void setZeroes(int[][] matrix) {
        int height = matrix.length;
        int width = matrix[0].length;
        int[][] map = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (matrix[i][j] == 0) {
                    for (int k = 0; k < width; k++) { // 标记整行
                        map[i][k] = 1;
                    }
                    for (int k = 0; k < height; k++) {
                        map[k][j] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (map[i][j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public void setZeroesOpt(int[][] matrix) {
        int height = matrix.length;
        int width = matrix[0].length;
        boolean[] row = new boolean[height];
        boolean[] col = new boolean[width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for (int i = 0; i < height; i++) {
            if (row[i]) {
                for (int j = 0; j < width; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < width; i++) {
            if (col[i]) {
                for (int j = 0; j < height; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }
}
