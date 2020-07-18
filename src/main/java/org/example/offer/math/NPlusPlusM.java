package org.example.offer.math;

public class NPlusPlusM {
    /*
        NO.12
        给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
        保证base和exponent不同时为0
     */
    /*
        思路:
            特例: n<0的情况处理
            1. 暴力
            2. 递归快速幂
            3. api: Math.pow(b,n)
     */
    public static double Power1(double b, int n) {
        if (n < 0) {
            b = 1 / b;
            n = -n;
        }
        double ret = 1.0;
        for (int i = 0; i < n; i++) {
            ret *= b;
        }
        return ret;
    }

    public static double Power2(double b, int n) {
        if (n < 0) {
            b = 1 / b;
            n = -n;
        }
        double x = b;
        double ret = 1.0;
        while (n != 0) {
            if ((n & 1) != 0) {
                // 奇数
                ret *= x;
            }
            x *= x;
            n >>= 1;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(Math.pow(8, -3));
        System.out.println(Power2(8, -3));
        System.out.println(Power1(8, -3));
    }
}
