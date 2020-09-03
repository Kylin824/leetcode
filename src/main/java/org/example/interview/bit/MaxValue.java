package org.example.interview.bit;

public class MaxValue {
    /*
    面试题 16.07. 最大数值
    编写一个方法，找出两个数字a和b中最大的那一个。不得使用if-else或其他比较运算符。

    1. 绝对值  max(a, b) = ( |a - b | + a + b ) / 2;

    2. 位运算
        令b-a
        若ab同号(diff==0) 则看b-a的最高位是0/1 判断b大还是a大
        若ab异号(diff==1) 则看b的符号是0/1 判断b大还是a大
    */

    public int maximumAbs(int a, int b) {
        long A = a;
        long B = b;
        return (int) ((Math.abs(A-B) + A + B)/2);
    }

    public int maximunBit(int a, int b) {
        int k = b - a >>> 31; // 计算b-a的最高位
        int aSign = a >>> 31; // a的符号位
        int bSign = b >>> 31; // b的符号位
        int diff = aSign ^ bSign; // 同号时diff为0，不同号时为1（此时看bSign就知道大小关系）
        k = k & (diff ^ 1) | bSign & diff;
        return a * k + b * (k ^ 1);
    }
}
