package org.example.hot100_v2.easy.bit;

/**
 * @author kylin
 * @date 2026/7/13
 */
public class _190 {

    public static int reverseBits(int n) {
        int ch = n & 1; // 符号位
        n >>>= 1;
        int c = 1 << 30; // 2^30
        int res = 0;
        while (n != 0) {
            int bit = n & 1;
            if (bit == 1) {
                res += c;
            }
            c >>>= 1;
            n >>>= 1;
        }
        return ch == 0 ? res : -res;
    }

    public static void main(String[] args) {
        System.out.println(reverseBits(43261596));
    }
}
