package org.example.interview.bit;

public class Add {
    /*
    面试题 17.01. 不用加号的加法
    设计一个函数把两个数字相加。不得使用 + 或者其他算术运算符。

    提示：
    a, b 均可能是负数或 0
    结果不会溢出 32 位整数
    */
    public int add(int a, int b) {
        while (b != 0) {
            int tmp = a;
            a = a ^ b;
            b = (tmp & b) << 1;
        }
        return a;
    }
}
