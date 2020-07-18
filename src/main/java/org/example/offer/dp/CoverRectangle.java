package org.example.offer.dp;

public class CoverRectangle {
    /*
        NO.10
        用2*1的小矩形横着或者竖着去覆盖更大的矩形。
        请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
     */
    /*
        思路:
            与青蛙跳台阶1类似
     */

    public static int RectCover(int n) {

        if (n == 0 || n == 1 || n == 2)
            return n;

        int[] f = new int[n+1];
        f[0] = 0;
        f[1] = 1;
        f[2] = 2;

        for (int i = 3; i <= n; i++) {
            f[i] = f[i-1] + f[i-2];
        }

        return f[n];
    }

    public static void main(String[] args) {
        System.out.println(RectCover(0));
    }
}
