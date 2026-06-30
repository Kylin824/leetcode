package org.example.hot100_v2.easy;

/**
 * 汉明距离
 * @author kylin
 * @date 2026/6/30
 */
public class _461 {

    public static int hammingDistance(int x, int y) {
        int n = 0;
        while (x != 0 || y != 0) {
            int x1 = x & 1;
            int y1 = y & 1;
            if (x1 != y1) {
                n++;
            }
            x = x >> 1;
            y = y >> 1;
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(3, 1));
    }
}
