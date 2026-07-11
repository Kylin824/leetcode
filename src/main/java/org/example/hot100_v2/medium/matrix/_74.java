package org.example.hot100_v2.medium.matrix;

/**
 * @author kylin
 * @date 2026/7/12
 */

public class _74 {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int left = 0, right = matrix.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (matrix[mid][0] > target) {
                right = mid - 1;
            } else if (matrix[mid][0] < target) {
                if (mid + 1 <= matrix.length - 1 && matrix[mid + 1][0] > target) {
                    left = mid;
                    break;
                } else {
                    left = mid + 1;
                }
            } else {
                return true;
            }
        }
        int row = left;
        left = 0;
        right = matrix[row].length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (matrix[row][mid] > target) {
                right = mid - 1;
            } else if (matrix[row][mid] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return target == matrix[row][left];
    }

    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 3));
        System.out.println(searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 11));
        System.out.println(searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 23));
        System.out.println(searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 30));
        System.out.println("=======");
        System.out.println(searchMatrix(new int[][]{{1}}, 0));
        System.out.println(searchMatrix(new int[][]{{1}}, 1));
        System.out.println(searchMatrix(new int[][]{{1}}, 2));
    }
}
