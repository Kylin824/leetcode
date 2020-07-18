package org.example.offer.dp;

public class RobotMoveCount {
    /*
        NO.66
        地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
        每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
        例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
        请问该机器人能够达到多少个格子？
     */
    /*
        思路: dfs
     */

    int dx[] = {1, -1, 0, 0}; // 右， 下， 左， 上
    int dy[] = {0, 0, 1, -1}; // 右， 下， 左， 上

    // 计算坐标的数位之和
    public int sum(int x) {
        int ans = 0;
        while (x > 0) {
            ans += x % 10;
            x /= 10;
        }
        return ans;
    }

    public int dfs(int threshold, int rows, int cols, int x, int y, boolean[][] visited) {

        visited[x][y] = true;
        int ans = 0;

        for (int i = 0; i < 4; i++) { // 向右， 下， 左， 上四个方向走
            int X = x + dx[i];
            int Y = y + dy[i];

            if (X >= 0 && Y >= 0 && X < rows && Y < cols && !visited[X][Y] && sum(X) + sum(Y) <= threshold) {
                ans = ans + dfs(threshold, rows, cols, X, Y, visited) + 1;
            }
        }
        return ans;
    }

    public int movingCount(int threshold, int rows, int cols)
    {
        if (threshold <= 0 || rows <= 0 || cols <= 0)
            return 0;

        boolean[][] visited = new boolean[rows][cols];
        return dfs(threshold, rows, cols, 0, 0, visited) + 1;
    }

    // 直接遍历只能通过25% 因为有些位置要前面能走通，该位置才能走到，所以需要dfs
    public int movingCount1(int threshold, int rows, int cols)
    {
        if (threshold <= 0 || rows <= 0 || cols <= 0)
            return 0;
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (sum(i) + sum(j) <= threshold)
                    count++;
                else
                    continue;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        RobotMoveCount rc = new RobotMoveCount();
        System.out.println(rc.movingCount1(10, 1, 100));
    }
}
