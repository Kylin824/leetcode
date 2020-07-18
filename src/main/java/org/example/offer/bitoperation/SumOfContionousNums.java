package org.example.offer.bitoperation;

public class SumOfContionousNums {
    /*
        NO>47
        求1+2+3+...+n
        不能使用 乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
     */
    /*
        思路
            递归 + 短路原理
            A && B 如果 A 不成立则 B不会执行，用来替代 if语句
     */

    // 递归版，有if
    public static int Sum_solution1(int n) {
        if (n > 1)
            return n + Sum_solution1(n - 1);
        else
            return n;
    }

    // 正解，短路原理代替if
    public static int Sum_Solution(int n) {
        boolean x = n > 1 && (n += Sum_Solution(n-1)) > 0;
        return n;
    }
}
