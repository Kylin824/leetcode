package org.example.leetcode.math;

public class ZeroesFactorial {
    /*
    172. 阶乘后的零
    给定一个整数 n，返回 n! 结果尾数中零的数量。

    零的数量跟5的数量有关
     */

    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            count += n / 5;
            n = n / 5;
        }
        return count;
    }
}
