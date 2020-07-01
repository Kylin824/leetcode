package org.example.offer;

public class JumpFloor {
    /*
        NO.08
        一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法
     */
    /*
        思路: f[n] = f[n-1] + f[n-2]
            1. 递归
            2. 递推
     */

    public static int JumpFloor1(int n) {
        if (n <= 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        return JumpFloor1(n-1) + JumpFloor1(n-2);
    }

    public static int JumpFloor2(int n) {
        int[] f = new int[n+1];
        f[0] = 0;
        f[1] = 1;
        f[2] = 2;
        for (int i = 3; i <= n; i++) {
            f[i] = f[i-1] + f[i-2];
        }
        return f[n];
    }

    public static void main(String[] args) {
        System.out.println(JumpFloor1(5));
        System.out.println(JumpFloor2(5));
    }

}
