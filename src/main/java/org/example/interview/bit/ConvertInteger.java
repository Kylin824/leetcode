package org.example.interview.bit;

public class ConvertInteger {
    /*
    面试题 05.06. 整数转换
    整数转换。编写一个函数，确定需要改变几个位才能将整数A转成整数B。

    示例1:
     输入：A = 29 （或者0b11101）, B = 15（或者0b01111）
     输出：2
     */
    public static int convertInteger(int A, int B) {
        int count = 0;
        int tmp = 1 << 31;
        while (A != 0 || B != 0) {
            if ((A & tmp) != (B & tmp)) {
                count++;
            }
            A = A << 1;
            B = B << 1;
        }
        return count;
    }

    public static int convertInteger1(int A, int B) {
        int count = 0;
        while (A != 0 || B != 0) {
            if ((A & 1) != (B & 1)) {
                count++;
            }
            A = A >>> 1;
            B = B >>> 1;  // >>> 无符号右移  忽略符号位 高位补0
        }
        return count;
    }

    public static int convertIntegerOpt(int A, int B) {
        int count = 0;
        for (int C = A ^ B; C != 0; C = C >>> 1) {
            count += C & 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(-729934991));
        System.out.println(Integer.toBinaryString(-729934991 >> 1));
        System.out.println(Integer.toBinaryString(-729934991 >>> 1));
        System.out.println(convertInteger1(1, 2));
//        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE << 1));
//        System.out.println(Integer.toBinaryString(1 << 31));
    }
}
