package org.example.hot100_v2.easy.dp;

/**
 * 爬楼梯
 *
 * @author kylin
 * @date 2026/6/26
 */
public class _70 {
    public int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int[] res = new int[n + 1];
        res[0] = 0;
        res[1] = 1; // 1
        res[2] = 2; // 1+1、2
//        res[3] = 3; // 1+1+1、1+2、2+1
//        res[4] = 5; // 1+1+1+1、1+2+1、2+1+1、1+1+2、2+2
        for (int i = 3; i <= n; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[n];
    }
}
