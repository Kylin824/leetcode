package org.example.hot100_v2.medium;

/**
 * 生命游戏
 *
 * @author kylin
 * @date 2026/7/19
 */

public class _289 {

    public void gameOfLife(int[][] board) {
        int h = board.length;
        int w = board[0].length;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                board[i][j] = deadOrAlive(board, i, j);
            }
        }
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                }
                if (board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }

    public int deadOrAlive(int[][] board, int i, int j) {
        int cur = board[i][j];
        int aliveCount = 0;
        if (i > 0) {
            if (board[i - 1][j] == 1 || board[i - 1][j] == 2) {
                aliveCount++;
            }
        }
        if (j > 0) {
            if (board[i][j - 1] == 1 || board[i][j - 1] == 2) {
                aliveCount++;
            }
        }
        if (i < board.length - 1) {
            if (board[i + 1][j] == 1 || board[i + 1][j] == 2) {
                aliveCount++;
            }
        }
        if (j < board[0].length - 1) {
            if (board[i][j + 1] == 1 || board[i][j + 1] == 2) {
                aliveCount++;
            }
        }
        if (i > 0 && j > 0) {
            if (board[i - 1][j - 1] == 1 || board[i - 1][j - 1] == 2) {
                aliveCount++;
            }
        }
        if (i > 0 && j < board[0].length - 1) {
            if (board[i - 1][j + 1] == 1 || board[i - 1][j + 1] == 2) {
                aliveCount++;
            }
        }
        if (i < board.length - 1 && j > 0) {
            if (board[i + 1][j - 1] == 1 || board[i + 1][j - 1] == 2) {
                aliveCount++;
            }
        }
        if (i < board.length - 1 && j < board[0].length - 1) {
            if (board[i + 1][j + 1] == 1 || board[i + 1][j + 1] == 2) {
                aliveCount++;
            }
        }
        if (cur == 1) {
            if (aliveCount < 2 || aliveCount > 3) {
                return 2; // 原来是活 下一轮变为死
            }
        }
        if (cur == 0) {
            if (aliveCount == 3) {
                return  3; // 原来是死 下一轮变为活
            }
        }
        return cur;
    }

    public static void main(String[] args) {
        _289 obj = new _289();
        int[][] board = {
                {0,1,0},
                {0,0,1},
                {1,1,1,},
                {0,0,0}
        };
        obj.gameOfLife(board);
        System.out.println(board);
    }
}
