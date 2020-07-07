package org.example.offer;

public class CutRope {
    /*
        NO.66
        给你一根长度为n的绳子，
        请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1，m<=n），
        每段绳子的长度记为k[1],...,k[m]。
        请问k[1]x...xk[m]可能的最大乘积是多少？
        例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
     */
    /*
        思路:
            DP

     */

    public int cutRope(int number) {
        if (number < 2)
            return 0;
        if (number == 2)
            return 1;
        if (number == 3 )
            return 2;
        int[] dp = new int[number+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 4;
        for (int i = 5; i <= number; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], j * dp[i-j]);
            }
        }
        return dp[number];
    }

    public static void main(String[] args) {
        CutRope cr = new CutRope();
        System.out.println(cr.cutRope(8));
    }
}
