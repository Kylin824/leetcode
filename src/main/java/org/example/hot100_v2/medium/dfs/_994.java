package org.example.hot100_v2.medium.dfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 腐烂的橘子
 *
 * BFS
 *
 * @author kylin
 * @date 2026/7/21
 */
public class _994 {

    public int orangesRotting(int[][] grid) {
        int freshCount = 0; // 只统计好橘子
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    freshCount++;
                }
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        // 特判：如果没有好橘子，直接返回 0（无需等待）
        if (freshCount == 0) {
            return 0;
        }
        int minutes = 0;
        while (!queue.isEmpty() && freshCount > 0) {
            int size = queue.size();
            minutes++;
            while (size-- > 0) {
                int[] poll = queue.poll(); // 腐烂橘子坐标
                int i = poll[0];
                int j = poll[1];
                grid[i][j] = 0;
                if (i > 0 && grid[i - 1][j] == 1) {
                    freshCount--;
                    queue.add(new int[]{i - 1, j});
                    grid[i - 1][j] = 2;
                }
                if (j > 0 && grid[i][j - 1] == 1) {
                    freshCount--;
                    queue.add(new int[]{i, j - 1});
                    grid[i][j - 1] = 2;
                }
                if (i < grid.length - 1 && grid[i + 1][j] == 1) {
                    freshCount--;
                    queue.add(new int[]{i + 1, j});
                    grid[i + 1][j] = 2;
                }
                if (j < grid[0].length - 1 && grid[i][j + 1] == 1) {
                    freshCount--;
                    queue.add(new int[]{i, j + 1});
                    grid[i][j + 1] = 2;
                }
            }
        }
        // 新鲜橘子是否全部腐烂完 是则返回耗时 否则返回-1
        return freshCount == 0 ? minutes : -1;
    }

    public static void main(String[] args) {
        _994 solution = new _994();
//        int[][] grid = new int[][]{{2,1,1}, {1,1,0}, {0,1,1}};
        int[][] grid = new int[][]{{1,2,1,1,2,1,1}};
        System.out.println(solution.orangesRotting(grid));
    }
}
