package org.example.hot100_v2.easy.idea;

/**
 * 判断给定的整数 n 是否是 3 的幂次方
 * @author kylin
 * @date 2026/7/14
 *
 * 妙解
 */

public class _326 {

    // 题目通常限定 n 为 32 位有符号整数（-2³¹ ~ 2³¹-1），范围内最大的 3 的幂是 3¹⁹ = 1162261467。
    // 如果一个数是 3 的幂，那么它一定能被这个最大幂整除：
    public boolean isPowerOfThree(int n) {
        return n > 0 && Math.pow(3, 19) % n == 0;
//        return n > 0 && 1162261467 % n == 0;
    }
}
