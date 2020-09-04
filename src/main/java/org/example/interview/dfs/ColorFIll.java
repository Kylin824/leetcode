package org.example.interview.dfs;

public class ColorFIll {
    /*
    面试题 08.10. 颜色填充
    编写函数，实现许多图片编辑软件都支持的「颜色填充」功能。
    待填充的图像用二维数组 image 表示，元素为初始颜色值。初始坐标点的横坐标为 sr 纵坐标为 sc。需要填充的新颜色为 newColor 。
    「周围区域」是指颜色相同且在上、下、左、右四个方向上存在相连情况的若干元素。
    请用新颜色填充初始坐标点的周围区域，并返回填充后的图像。

    示例：
    输入：
    image = [[1,1,1],
            [1,1,0],
            [1,0,1]]
    sr = 1, sc = 1, newColor = 2
    输出：[[2,2,2],
         [2,2,0],
         [2,0,1]]
    解释:
    初始坐标点位于图像的正中间，坐标 (sr,sc)=(1,1) 。
    初始坐标点周围区域上所有符合条件的像素点的颜色都被更改成 2 。
    注意，右下角的像素没有更改为 2 ，因为它不属于初始坐标点的周围区域。
    */

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int[][] flags = new int[image.length][image[0].length];
        return fill(image, sr, sc, newColor, flags);

    }

    public static int[][] fill(int[][] image, int sr, int sc, int newColor, int[][] flags) {
        int n = image[sr][sc];
        image[sr][sc] = newColor;
        flags[sr][sc] = 1;
        if (sr > 0 && image[sr - 1][sc] == n && flags[sr - 1][sc] == 0) {
            image = fill(image, sr - 1, sc, newColor, flags);
        }
        if (sr < image.length - 1 && image[sr + 1][sc] == n && flags[sr + 1][sc] == 0) {
            image = fill(image, sr + 1, sc, newColor, flags);
        }
        if (sc > 0 && image[sr][sc - 1] == n && flags[sr][sc - 1] == 0) {
            image = fill(image, sr, sc - 1, newColor, flags);
        }
        if (sc < image[0].length - 1 && image[sr][sc + 1] == n && flags[sr][sc + 1] == 0) {
            image = fill(image, sr, sc + 1, newColor, flags);
        }
        return image;
    }

    public int[][] floodFillOpt(int[][] image, int sr, int sc, int newColor) {
        int n = image[sr][sc];
        image[sr][sc] = newColor;
        if (sr > 0 && image[sr - 1][sc] == n && image[sr - 1][sc] != newColor) {
            image = floodFillOpt(image, sr - 1, sc, newColor);
        }
        if (sr < image.length - 1 && image[sr + 1][sc] == n && image[sr + 1][sc] != newColor) {
            image = floodFillOpt(image, sr + 1, sc, newColor);
        }
        if (sc > 0 && image[sr][sc - 1] == n && image[sr][sc - 1] != newColor) {
            image = floodFillOpt(image, sr, sc - 1, newColor);
        }
        if (sc < image[0].length - 1 && image[sr][sc + 1] == n && image[sr][sc + 1] != newColor) {
            image = floodFillOpt(image, sr, sc + 1, newColor);
        }
        return image;

    }

    public static void main(String[] args) {
        int[][] arr = {{0, 0, 1}, {0, 1, 1}};
        int[][] ret = floodFill(arr, 1, 1, 1);
        System.out.println(ret);
    }
}
