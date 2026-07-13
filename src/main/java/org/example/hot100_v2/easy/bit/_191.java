package org.example.hot100_v2.easy.bit;

/**
 * @author kylin
 * @date 2026/7/13
 */
public class _191 {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1; // 最右一位
            n >>>= 1;
        }
        return count;
    }
}
