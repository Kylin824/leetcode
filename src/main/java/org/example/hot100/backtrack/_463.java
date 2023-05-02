package org.example.hot100.backtrack;

import java.util.Arrays;

public class _463 {

    // 岛屿周长

    public static void main(String[] args) {
        _463 o = new _463();

        int[][] grid = new int[][]{
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };
        System.out.println(o.islandPerimeter(grid)); // 16
        System.out.println(Arrays.deepToString(grid));
    }

    int num = 0;

    public int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                }
            }
        }
        return num;
    }

    public void dfs(int[][] grid, int i, int j) {

        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] != 0) {
            if (grid[i][j] == 2) {
                return;
            }
        } else {
            num++;
            return;
        }

        grid[i][j] = 2;

        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
    }

}
