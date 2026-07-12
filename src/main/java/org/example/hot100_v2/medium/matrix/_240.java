package org.example.hot100_v2.medium.matrix;

/**
 * @author kylin
 * @date 2026/7/12
 */

public class _240 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int h = 0, w = matrix[0].length - 1;
        // 从右上角开始向左向下找
        while (h <= matrix.length - 1 && w >= 0) {
            if (matrix[h][w] == target) {
                return true;
            } else if (matrix[h][w] > target) { // 排除第w列
                w -= 1;
            } else { // 排除第h行
                h += 1;
            }
        }
        return false;
    }
}
