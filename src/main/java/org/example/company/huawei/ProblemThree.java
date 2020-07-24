package org.example.company.huawei;

import java.util.*;

public class ProblemThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int[] dp = new int[m];
        dp[0] = sc.nextInt();

        int total = dp[0];
        for (int i = 1; i < m; i++) {
            int tmp = sc.nextInt();
            int cap = 2 * dp[i - 1] - total;
            if (tmp <= cap) {
                dp[i] = dp[i - 1];
                total += tmp;
            }
            else {
                dp[i] = Math.max(tmp, total - tmp);
                total += tmp;
            }
        }
        System.out.println(dp[m-1]);
    }
}
