package org.example.offer.dp;

public class JumpFloorII {
    /*
        NO.09
        一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
     */
    /*
        思路:
            1. 递归
            2. 递推 f[n] = f[n-1] + f[n-2] + ... + f[1] + f[0]
            2. 数学 f[n] = 2f[n-1]
     */
    public static int JumpFloorII1(int n) {
        if (n == 0 || n == 1)
            return 1;
        int res = 0;
        for (int i = n - 1; i >= 0; i--) {
            res += JumpFloorII1(i);
        }
        return res;
    }

    public static int JumpFloorII2(int n) {
        int[] f = new int[n+1];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                f[i] += f[j];
            }
        }
        return f[n];
    }

    public static void main(String[] args) {
        System.out.println(JumpFloorII2(5));
        System.out.println(JumpFloorII1(5));
    }

}
