package org.example.leetcode.math;

public class SqrtOfNum {
    /*
    69. x 的平方根
    实现 int sqrt(int x) 函数。

    计算并返回 x 的平方根，其中 x 是非负整数。

    由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
     */

    // 牛顿迭代法  y = x^2
    public static int qs (int y) {
        if (y <= 0) {
            return 0;
        }
        double xn = y; // 任意初始值
        double xn_1 = (xn + y / xn) / 2;
        while (Math.abs(xn_1 - xn) >= 1) {
            xn = xn_1;
            xn_1 = (xn + y / xn) / 2;
        }
        return (int)xn_1;
    }

    public static void main(String[] args) {
        System.out.println(qs(8));
    }

}
