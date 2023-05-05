package org.example.hot100.bi_search;

public class _74 {

    // 搜索二维矩阵I

    // 编写一个高效的算法来判断m x n矩阵中，是否存在一个目标值。该矩阵具有如下特性：
    //
    //每行中的整数从左到右按升序排列。
    //每行的第一个整数大于前一行的最后一个整数。


    public static void main(String[] args) {
        _74 o = new _74();

        int[][] matrix = new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        System.out.println(o.searchMatrix(matrix, 11));
        ;
    }

    public boolean searchMatrix(int[][] matrix, int target) {

        int l = 0;
        int r = matrix.length - 1;

        int mid = 0;

        while (l <= r) {
            mid = (l + r) / 2;
            if (matrix[mid][matrix[0].length - 1] < target) {
                l = mid + 1;
            } else if (matrix[mid][0] == target || matrix[mid][matrix[0].length - 1] == target) {
                return true;
            } else if (matrix[mid][0] < target  && target < matrix[mid][matrix[0].length - 1]) {
                break;
            } else if (target < matrix[mid][0]){
                r = mid - 1;
            }
        }

        l = 0;
        r = matrix[0].length - 1;

        int m;

        while (l <= r) {
            m = (l + r) / 2;
            if (matrix[mid][m] < target) {
                l = m + 1;
            } else if (matrix[mid][m] == target) {
                return true;
            } else {
                r = m - 1;
            }
        }

        return false;
    }
}
