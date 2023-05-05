package org.example.hot100.backtrack;

import java.security.interfaces.DSAKey;

public class _221 {

    public static void main(String[] args) {
        _221 o = new _221();
//        char[][] matrix = new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
//        char[][] matrix = new char[][]{{'0', '1'}, {'1', '0'}};
//        char[][] matrix = new char[][]{{'1','1','1','0','0'},{'1','1','1','0','0'},{'1','1','1','1','1'},{'0','1','1','1','1'},{'0','1','1','1','1'},{'0','1','1','1','1'}};
        char[][] matrix = new char[][]{{'0','0','0','1','0','1','1','1'},{'0','1','1','0','0','1','0','1'},{'1','0','1','1','1','1','0','1'},{'0','0','0','1','0','0','0','0'},{'0','0','1','0','0','0','1','0'},{'1','1','1','0','0','1','1','1'},{'1','0','0','1','1','0','0','1'},{'0','1','0','0','1','1','0','0'},{'1','0','0','1','0','0','0','0'}};
        System.out.println(o.maximalSquare(matrix));
    }

    public int maximalSquare(char[][] matrix) {
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    int k = 1;
                    while (i + k < matrix.length && j + k < matrix[0].length && isSquare(matrix, i, j, k)) {
                        k++;
                    }
                    max = Math.max(max, k);
                }
            }
        }
        return max * max;
    }


    public boolean isSquare(char[][] matrix, int i, int j, int k) {
        for (int r = i; r <= i + k; r++) {
            if (matrix[r][j + k] == '0') {
                return false;
            }
        }
        for (int l = j; l <= j + k; l++) {
            if (matrix[i + k][l] == '0') {
                return false;
            }
        }
        return true;
    }
}
