package org.example.offer.math;

public class NumbersOfOneInBinary {
    /*
        NO.11
        输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
     */
    /*
        思路:
            1. 位运算 :补码 = 原码取反 + 1
            2. api转二进制字符串 Integer.toBinaryString()
     */
    public static int NumberOf1(int n) {
        String bin = Integer.toBinaryString(n);
        int count = 0;
        for (int i = 0; i < bin.length(); i++) {
            if (bin.charAt(i) == '1')
                count++;
        }
        return count;
    }

    public static int NumberOf11(int n) {
        int count = 0;
        // 正数
        if (n >= 0) {
            while (n != 0) {
                count += n % 2;
                n = n >> 1;
            }
        }
        // 负数
        else {
            // 转正数，数0个数
            n = ~n;
            while (n != 0) {
                count += n % 2;
                n = n >> 1;
            }
            count = 32 - count;
        }
        return count;
    }

    public static void main(String[] args) {
//        System.out.println(NumberOf1(-15));
//        System.out.println(NumberOf11(7));

        int n = -15;
        String bin = Integer.toBinaryString(n);
        System.out.println(bin);
        n = ~n;
//        n = n & 0xFFFFFFFF;
        System.out.println(n);
        bin = Integer.toBinaryString(n);
        System.out.println(bin);
    }
}
