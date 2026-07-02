package org.example.hot100_v2.medium;

/**
 * 90度原地右旋转矩阵
 * @author kylin
 * @date 2026/7/2
 */
public class _48 {

    public static void rotate(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        int tall = matrix.length;
        int wide = matrix[0].length;

        for (int t = 0; t < tall / 2; t++) {
            for (int w = t; w < wide - t - 1; w++) {
                int tmp = matrix[t][w]; // 暂存左上角
                matrix[t][w] = matrix[tall - w - 1][t];
                matrix[tall - w - 1][t] = matrix[tall - t - 1][wide - w - 1];
                matrix[tall - t - 1][wide - w - 1] = matrix[w][wide - t - 1];
                matrix[w][wide - t - 1] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] raw = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        System.out.println(raw[0][1]);
        System.out.println(raw[1][0]);
        rotate(raw);
        System.out.println(raw);
    }
}
