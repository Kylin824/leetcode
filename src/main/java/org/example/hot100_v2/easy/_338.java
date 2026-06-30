package org.example.hot100_v2.easy;

/**
 * 比特位计数
 *
 * @author kylin
 * @date 2026/6/30
 */
public class _338 {

    public int[] countBits(int n) {
        if (n == 0) {
            return new int[]{0};
        }
        if (n == 1) {
            return new int[]{0, 1};
        }
        int[] res = new int[n + 1];
        res[0] = 0;
        res[1] = 1;
        int pre = 0;
        for (int i = 2; i <= n; i++) {
            // 2的n次方
            if ((i & i - 1) == 0) {
                res[i] = 1;
                pre = i; // 2, 4, 8, 16
            } else {
                res[i] = res[pre] + res[i - pre];
            }
        }
        return res;
    }
}
