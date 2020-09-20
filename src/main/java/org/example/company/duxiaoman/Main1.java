package org.example.company.duxiaoman;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] res = new int[t];
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            sc.nextLine();
            char[][] maze = new char[n][m];
            int r = 0, c = 0;
            for (int j = 0; j < n; j++) {
                String line = sc.next();
                int k = 0;
                for (char ch : line.toCharArray()) {
                    if (ch == '@') {
                        r = j;
                        c = k;
                    }
                    maze[j][k++] = ch;
                }
            }
            res[i] = bfs(maze, n, m, r, c);
        }
        for (int re : res) {
            System.out.println(re);
        }
    }

    public static int bfs(char[][] maze, int n, int m, int r, int c) {
        int dx[] = {1, 0, -1, 0};
        int dy[] = {0, 1, 0, -1};
        int[][] visited = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        int count = 0;
        boolean flag = false;
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            if (p[0] == 0 || p[0] == n - 1 || p[1] == 0 || p[1] == m - 1) {
                flag = true;
                break;
            }
            for (int i = 0; i < 4; i++) {
                int x = p[0] + dx[i];
                int y = p[1] + dy[i];
                if (x >= 0 && y >= 0 && x <= n - 1 && y <= m - 1 && maze[x][y] == '.'  && visited[x][y] == 0) {
                    visited[x][y] = 1;
                    queue.add(new int[]{x, y});
                }
            }
        }
        if (flag) {
            return count;
        }
        else {
            return -1;
        }
    }
}
