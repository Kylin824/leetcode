package org.example.hot100_v2.medium.backtrack;


/**
 * 单词搜索
 *
 * 二维矩阵中搜索单词
 *
 * @author kylin
 * @date 2026/7/21 1:24
 */

public class _79 {

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (backtrack(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backtrack(char[][] board, String word, int i, int j, int pos) {
        // 成功匹配所有字符
        if (pos == word.length()) {
            return true;
        }
        // 检查边界
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        // 检查字符是否匹配
        if (board[i][j] != word.charAt(pos)) {
            return false;
        }
        char tmp = board[i][j];
        board[i][j] = '#'; // 标记已访问
        boolean found = backtrack(board, word, i + 1, j, pos + 1)
                || backtrack(board, word, i - 1, j, pos + 1)
                || backtrack(board, word, i, j + 1, pos + 1)
                || backtrack(board, word, i, j - 1, pos + 1);
        board[i][j] = tmp;
        return found;
    }
}
