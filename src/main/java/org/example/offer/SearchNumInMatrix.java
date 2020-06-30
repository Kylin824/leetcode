package org.example.offer;

public class SearchNumInMatrix {
    /*
        NO.01
        二维数组从左往右，从上往下递增，判断其中是否存在给定的数
     */
    /*
        思路: 从左下角开始，大则往上走，小则往右走
        tips:
     */

    public static boolean isFind(int target, int [][] array) {

        // 行
        int rows = array.length - 1;
        // 列数
        int cols = array[0].length - 1;

        int r = rows;
        int c = 0;

        while (r >= 0 && c <= cols) {
            if (array[r][c] == target)
                return true;
            else if (array[r][c] > target)
                r--;
            else if (array[r][c] < target)
                c++;
        }
        return false;
    }

    public static void main(String[] args) {

        // 7,[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]

        int[][] array = {{1,2,8,9}, {2,4,9,12},{4,7,10,13},{6,8,11,15}};

//        int[] array = {1, 2, 3};

        System.out.println(array.length);
        System.out.println(array[0].length);

        System.out.println(isFind(7, array));
    }
}
