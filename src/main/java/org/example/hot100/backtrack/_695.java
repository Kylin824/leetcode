package org.example.hot100.backtrack;

public class _695 {


    public static void main(String[] args) {
        _695 o = new _695();
        int[][] grid = new int[][]{
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };

//        int[][] grid = new int[][]{
//                {1}
//        };
        System.out.println(o.maxAreaOfIsland(grid)); // 6
    }

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j, 0);
                    max = Math.max(max, area);
                }
            }
        }
        return max;
    }

    public int dfs(int[][] grid, int i, int j, int area) {
        if (i < 0 || j < 0 || i + 1 > grid.length || j + 1 > grid[0].length || grid[i][j] == 2 || grid[i][j] == 0) {
            return area;
        }
        if (grid[i][j] == 1) {
            area++;
            grid[i][j] = 2;
        }
        area = dfs(grid, i + 1, j, area);
        area = dfs(grid, i - 1, j, area);
        area = dfs(grid, i, j + 1, area);
        area = dfs(grid, i, j - 1, area);
        return area;
    }
}
