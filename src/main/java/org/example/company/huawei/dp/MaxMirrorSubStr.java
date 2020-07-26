package org.example.company.huawei.dp;

import java.util.Scanner;

public class MaxMirrorSubStr {
    /*
        HJ85
        求最长对称子串长度
     */
    /*
        把字符串反转，之后变成求两个字符串的最长公共子串问题
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            String revStr = new StringBuilder(str).reverse().toString();
            int m = str.length();
            int[][] dp = new int[m + 1][m + 1];
            int maxLen = 0;
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= m; j++) {
                    if (str.charAt(i - 1) == revStr.charAt(j - 1)) {
                        dp[i][j] = dp[i -1][j - 1] + 1;
                        maxLen = Math.max(maxLen, dp[i][j]);
                    }
                    else {
                        // dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                        dp[i][j] = 0;
                    }
                }
            }
            System.out.println(maxLen);

//            for (int i = 0; i <= m; i++) {
//                for (int j = 0; j <= m; j++) {
//                    System.out.print(dp[i][j] + " ");
//                }
//                System.out.println();
//            }
        }
    }
}
