package org.example.hot100.backtrack;

import java.util.Arrays;

public class _200 {

    // 岛屿数量

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        _200 o = new _200();
        System.out.println(o.numIslands(grid));

        System.out.println(Arrays.deepToString(grid));
    }


    public int numIslands(char[][] grid) {
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    num++;
                    dfs(grid, i, j);
                }
            }
        }
        return num;
    }

    public void dfs(char[][] grid, int i, int j) {

        if (grid[i][j] == '0' || grid[i][j] == '2') {
            return;
        }

        if (grid[i][j] == '1') {
            grid[i][j] = '2';
        }

        if (i - 1 >= 0) {
            dfs(grid, i - 1, j);
        }
        if (j + 1 < grid[0].length) {
            dfs(grid, i, j + 1);
        }
        if (i + 1 < grid.length) {
            dfs(grid, i + 1, j);
        }
        if (j - 1 >= 0) {
            dfs(grid, i, j - 1);
        }

    }
}
