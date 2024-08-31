package org.example.hot100.bit;

/**
 * @author kylin
 * @date 2024/8/31
 */
public class _191 {

    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n & 1;
            n >>>= 1; //  无符号右移一位
        }
        return sum;
    }

}
