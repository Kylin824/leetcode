package org.example.hot100.bit;

public class _461 {

    /**
     * 汉明距离：两个数的二进制中不同字符的数量
     */
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }


    public int hammingDistance1(int x, int y) {
        int s = x ^ y, ret = 0;
        while (s != 0) {
            ret += s & 1;
            s = s >> 1;

        }
        return ret;
    }

    public int hammingDistance2(int x, int y) {
        int s = x ^ y, ret = 0;
        while (s != 0) {
            ret++;
            s = s & (s - 1); // 去掉s最右边第一个1
        }
        return ret;
    }
}
