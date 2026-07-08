package org.example.archive.hot100;

//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−2^31, 2^31 − 1] ，就返回 0。
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
//
//
// 示例 1：
//
//
//输入：x = 123
//输出：321
//
//
// 示例 2：
//
//
//输入：x = -123
//输出：-321
//
//
// 示例 3：
//
//
//输入：x = 120
//输出：21
//
//
// 示例 4：
//
//
//输入：x = 0
//输出：0
//
//
//
//
// 提示：
//
//
// -2³¹ <= x <= 2³¹ - 1
//
//
// Related Topics 数学 👍 3963 👎 0

public class _7 {

    public int reverse(int x) {
        int res = 0;
        int b = 1;
        if (x < 0) {
            b = -1;
            x = -x;
        }
        while (x > 0) {
            int a = x % 10;
            if (res > Integer.MAX_VALUE / 10) {
                return 0;
            } else if (res == Integer.MAX_VALUE / 10) {
                if (a > Integer.MAX_VALUE % 10 + 1) {
                    return 0;
                } else if (a == Integer.MAX_VALUE % 10 + 1) {
                    if (b > 0) {
                        return 0;
                    }
                }
            }
            res *= 10;
            res += a;
            x = x / 10;
        }
        return res * b;
    }

    public static void main(String[] args) {
        _7 a = new _7();
        System.out.println(a.reverse(123));
        System.out.println(a.reverse(-123));
        System.out.println(a.reverse(120));
        System.out.println(a.reverse(0));
    }
}
