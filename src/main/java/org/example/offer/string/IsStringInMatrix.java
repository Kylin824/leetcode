package org.example.offer.string;

public class IsStringInMatrix {
    /*
        NO.65
        给定一个二维字符串矩阵mat,和一个字符串str,判断str是否可以在mat中匹配。
        例如:
            [a b c e]   "bcced" -> true
            [s f c s]   "abcb" -> false
            [a d e e]
     */
    /*
        思路: dfs
     */

    boolean[][] visited;
    int height;
    int width;
    int strLen;

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        visited = new boolean[rows][cols];
        height = rows;
        width = cols;
        strLen = str.length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(dfs(matrix, i, j, 0, str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[] matrix, int i, int j, int pos, char[] str){
        if (i < 0 || i >= height || j < 0 || j >= width) {
            return false;
        }

        char ch = matrix[i * width + j];
        if (visited[i][j] || ch != str[pos])
            return false;

        // 如果匹配，判断是否匹配到最后一个字符
        if (pos + 1 == str.length)
            return true;

        // 字符成功匹配，标记不能再次进入
        visited[i][j] = true;

        // 开始递归匹配右下左上四个方向

        // 右
        if (dfs(matrix, i, j + 1, pos + 1, str))
            return true;
        if (dfs(matrix, i + 1, j, pos + 1, str))
            return true;
        if (dfs(matrix, i, j - 1, pos + 1, str))
            return true;
        if (dfs(matrix, i - 1, j, pos + 1, str))
            return true;

        // 如果4个方向都无法匹配 str[pos + 1]
        // 则回溯， 将'#' 还原成 ch
        visited[i][j] = false;
        // 说明此次匹配是不成功的
        return false;
    }
}
