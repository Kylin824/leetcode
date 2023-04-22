package org.example.hot100.backtrack;

public class _79 {

    public static void main(String[] args) {
        _79 o = new _79();
//        System.out.println(o.exist(new char[][]{{'a', 'b', 'c'}, {'s', 'f', 'c'}, {'a', 'd', 'e'}}, "abfs"));
//        System.out.println(o.exist(new char[][]{{'a'}, {'b'}, {'d'}}, "abcd"));
//        System.out.println(o.exist(new char[][]{{'a', 'b', 'c', 'e'}, {'s', 'f', 'c', 's'}, {'a', 'd', 'e', 'e'}}, "abcb"));
//        System.out.println(o.exist(new char[][]{{'a', 'b', 'c', 'e'}}, "abce"));
//        System.out.println(o.exist(new char[][]{{'a'}, {'b'}, {'c'}, {'e'}}, "abcb"));
        System.out.println(o.exist(new char[][]{{'a'}}, "a"));
    }


    // 回溯 + 剪枝
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited[i][j] = true;
                    if (existSub(board, word, 1, i, j, visited)) {
                        return true;
                    }
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }

    public boolean existSub(char[][] board, String word, int depth, int i, int j, boolean[][] visited) {

        if (board[i][j] != word.charAt(depth - 1)) {
            return false;
        }

        if (depth == word.length()) {
            return true;
        }

        // 上
        if (i - 1 >= 0 && !visited[i - 1][j]) {
            visited[i - 1][j] = true;
            if (existSub(board, word, depth + 1, i - 1, j, visited)) return true;
            visited[i - 1][j] = false;
        }

        // 右
        if (j + 1 < board[0].length && !visited[i][j + 1]) {
            visited[i][j + 1] = true;
            if (existSub(board, word, depth + 1, i, j + 1, visited)) return true;
            visited[i][j + 1] = false;
        }
        //下
        if (i + 1 < board.length && !visited[i + 1][j]) {
            visited[i + 1][j] = true;
            if (existSub(board, word, depth + 1, i + 1, j, visited)) return true;
            visited[i + 1][j] = false;
        }
        // 左
        if (j - 1 >= 0 && !visited[i][j - 1]) {
            visited[i][j - 1] = true;
            if (existSub(board, word, depth + 1, i, j - 1, visited)) return true;
            visited[i][j - 1] = false;
        }
        return false;
    }
}
