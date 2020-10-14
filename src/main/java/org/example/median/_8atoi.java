package org.example.median;

public class _8atoi {
    /*
    8. 字符串转换整数 (atoi)
    请你来实现一个 atoi 函数，使其能将字符串转换成整数。

    首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
     */

    public int myAtoi(String str) {
        str = str.trim();
        if (str.length() == 0)
            return 0;
        if (str.charAt(0) != '+' && str.charAt(0) != '-' && !Character.isDigit(str.charAt(0)))
            return 0;
        long ans = 0L;
        boolean neg = str.charAt(0) == '-';
        int i = !Character.isDigit(str.charAt(0)) ? 1 : 0;
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            ans = ans * 10 + (str.charAt(i) - '0');
            i++;
            if (!neg && ans > Integer.MAX_VALUE) { // 正数
                ans = Integer.MAX_VALUE;
                break;
            }
            if (neg && ans > 1L + Integer.MAX_VALUE) { // 负数
                ans = 1L + Integer.MAX_VALUE;
                break;
            }
        }
        return neg ? (int) -ans : (int) ans;
    }
}
