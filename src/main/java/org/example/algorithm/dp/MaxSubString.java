package org.example.algorithm.dp;

import java.util.Scanner;

public class MaxSubString {
    // 最长公共子串
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String str1 = sc.next();
            String str2 = sc.next();
            int m = str1.length();
            int n = str2.length();
            int maxLen = 0;
            int[][] dp = new int[m+1][n+1];
            for(int i = 1;i <= m; i++){
                for(int j = 1; j <= n; j++){
                    if(str1.charAt(i-1) == str2.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1] + 1;
                        maxLen = Math.max(maxLen, dp[i][j]);
                    }else{
                        dp[i][j] = 0;   //区别在这儿
                    }
                }
            }
            System.out.println(maxLen);
        }
        sc.close();
    }
}
