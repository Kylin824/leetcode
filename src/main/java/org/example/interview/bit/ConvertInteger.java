package org.example.interview.bit;

public class ConvertInteger {
    /*
    面试题 05.06. 整数转换
    整数转换。编写一个函数，确定需要改变几个位才能将整数A转成整数B。
     */
    public static int convertInteger(int A, int B) {
        if (A < 0)
            A = -A;
        if (B < 0)
            B = -B;
        int tmp = A ^ B;
        int count = 0;
        while (tmp != 0) {
            if ((tmp & 1) == 1)
                count++;
            tmp = tmp >> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(convertInteger(826966453, -729934991));
        System.out.println(Integer.toBinaryString(826966453));
        System.out.println(Integer.toBinaryString(-729934991));
    }
}
