package org.example.leetcode.math;

import scala.Int;

public class ReverseInteger {
    /*
        7. 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
        示例 1:
        输入: 123
        输出: 321

         示例 2:
        输入: -123
        输出: -321

        示例 3:
        输入: 120
        输出: 21
     */
    public static void main(String[] args) {
        int i = -123;
//        System.out.println(String.valueOf(i));
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
        System.out.println(reverse(-2147483648));
    }

    public static int reverse(int x) {
        if (x == 0) return x;
        if (x == -2147483648) return 0;
        int flag = 1;
        if (x < 0) {
            x = -x;  // 这里反转会溢出
            flag = 0;
        }
        String str = String.valueOf(x);
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        long r = Long.parseLong(sb.toString());
        if (r > Integer.MAX_VALUE || -r < Integer.MIN_VALUE) {
            return 0;
        }
        else {
            return flag == 1 ? (int)r : (int)-r;
        }
    }
}
