package org.example.offer.dp;

public class FibonaciArray {
    /*
        NO.07
        输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。n<=39
     */

    public static int Fibonacci(int n) {
        if (n == 0 || n == 1)
            return n;
        return Fibonacci(n-1) + Fibonacci(n-2);
    }

    public static int Fibonacci1(int n) {
        if (n == 0 || n == 1)
            return n;

        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(Fibonacci(7));
        System.out.println(Fibonacci1(7));
    }
}
