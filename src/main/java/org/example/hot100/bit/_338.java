package org.example.hot100.bit;

import java.util.Arrays;

public class _338 {

    // tag: bit
    // tag: dp

    public static void main(String[] args) {

        int[] ints = countBits2(5);
        System.out.println(Arrays.toString(ints));
    }


    // 执行用时： 5 ms  击败了 17.32% 的用户
    // 外层循环 O(n) 内层循环 O(log n) 总时间复杂度：O(n log n)
    public static int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int count = 0;
            int b = i;
            while (b != 0) {
                count += b & 1;
                b = b >> 1;
            }
            res[i] = count;
        }
        return res;
    }

    public static int[] countBits1(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            res[i] = Integer.bitCount(i);
        }
        return res;
    }

    public static int[] countBits2(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            // 偶数 最后一位是0  则1的个数与 i/2 的个数相同
            if (i % 2 == 0) {
                res[i] = res[i >> 1];
            }
            // 奇数 最后一位是1 则1的个数=前一个偶数的个数+1
            else {
                res[i] = res[i - 1] + 1;
            }
        }
        return res;
    }
}