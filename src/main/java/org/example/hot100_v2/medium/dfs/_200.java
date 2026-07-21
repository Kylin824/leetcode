package org.example.hot100_v2.medium.dfs;

import java.util.Arrays;

/**
 * @author kylin
 * @date 2026/7/9
 */
public class _200 {



    public static int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j); // 一次dfs会把所有相连通的1置为0
                    count++;
                }
            }
        }
        return count;
    }

    public static void dfs(char[][] grid, int h, int w) {
        if (h < 0 || h >= grid.length || w < 0 || w >= grid[0].length || grid[h][w] == '0') {
            return;
        }
        grid[h][w] = '0';
        dfs(grid, h + 1, w);
        dfs(grid, h, w + 1);
        dfs(grid, h - 1, w);
        dfs(grid, h, w - 1);
    }

    public static void main(String[] args) {

//        char[][] grid = new char[][]{
//                {'1', '1', '1', '1', '0'},
//                {'1', '1', '0', '1', '0'},
//                {'1', '1', '0', '0', '0'},
//                {'0', '0', '0', '0', '0'}};  // 1

//        char[][] grid = new char[][]{
//                {'1','1','0','0','0'},
//                {'1','1','0','0','0'},
//                {'0','0','1','0','0'},
//                {'0','0','0','1','1'}
//        }; // 3

//        char[][] grid = new char[][]{{'1', '1', '1'}, {'0', '1', '0'}, {'1', '1', '1'}}; // 1
        char[][] grid = new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}}; // 1

        System.out.println(numIslands(grid));
        System.out.println(Arrays.deepToString(grid));
    }
}
