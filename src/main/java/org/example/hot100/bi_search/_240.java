package org.example.hot100.bi_search;

import org.apache.hadoop.yarn.webapp.hamlet.HamletSpec;

public class _240 {

    // 搜索二维矩阵II

    //编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
    //
    //每行的元素从左到右升序排列。
    //每列的元素从上到下升序排列。

    public static void main(String[] args) {
        _240 o = new _240();

//        int[][]  matrix = new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
//        int[][]  matrix = new int[][]{{1,3,5,7,9},{2,4,6,8,10},{11,13,15,17,19},{12,14,16,18,20},{21,22,23,24,25}};
//        int[][]  matrix = new int[][]{{-5}};
//        int[][]  matrix = new int[][]{{1, 4}, {2, 5}};
        int[][]  matrix = new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};

        System.out.println(o.searchMatrix(matrix, 19));;
    }

    public boolean searchMatrix(int[][] matrix, int target) {

        int l = 0;
        int r = matrix.length - 1;

        int mid = 0;



        // 定位到前row行
        while (l <= r) {
            if (matrix[l][0] == target || matrix[r][0] == target) {
                return true;
            }
            mid = (l + r) / 2;
            if (matrix[mid][0] < target) {
                l = mid + 1;
                if (l <= matrix.length - 1 && matrix[l][0] > target) {
                    break;
                }
            } else if (matrix[mid][0] == target) {
                return true;
            } else {
                r = mid - 1;
                if (r >= 0 && matrix[r][0] < target) {
                    mid = r;
                    break;
                }
            }
        }

        int row = mid;

        // 对前row行每一行进行二分查找
        for (int i = 0; i <= row; i++) {
            l = 0;
            r = matrix[0].length - 1;
            while (l <= r) {
                if (matrix[i][l] == target || matrix[i][r] == target) {
                    return true;
                }
                if (matrix[i][l] > target || matrix[i][r] < target) {
                    break;
                }
                mid = (l + r) / 2;
                if (matrix[i][mid] < target) {
                    l = mid + 1;
                } else if (matrix[i][mid] == target) {
                    return true;
                } else {
                    r = mid - 1;
                }
            }
        }

        return false;

    }
}
