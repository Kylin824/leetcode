package org.example.interview.bit;

public class Exchange {
    /*
    面试题 05.07. 配对交换
    配对交换。编写程序，交换某个整数的奇数位和偶数位，尽量使用较少的指令（也就是说，位0与位1交换，位2与位3交换，以此类推）。

    示例1:
     输入：num = 2（或者0b10）
     输出 1 (或者 0b01)

     5 = 0101  取奇数位
     a = 1010  取偶数位
     */
    public int exchangeBits(int num) {
        return ((num & 0x55555555) << 1) | ((num & 0xaaaaaaaa) >> 1);
    }
}
