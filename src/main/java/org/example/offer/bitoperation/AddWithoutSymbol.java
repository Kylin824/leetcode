package org.example.offer.bitoperation;

public class AddWithoutSymbol {
    /*
        NO.48
        不用+-X/做加法
     */
    /*
        思路：位运算

            使用位运算实现二位加法：
            按位加法： res1 = 11 ^ 01 = 10
            与运算进位： res2 = (11 & 01) << 1 = ( 01 ) << 1 = 010
            res1 ^ res2 = 10 ^ 010 = 00
            (10 & 10) << 1 = 100

     */
    public int Add(int num1,int num2) {
        int result = 0;
        int carry = 0;
        do {
            result = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = result;
            num2 = carry;
        } while (carry != 0);
        return result;
    }
}
