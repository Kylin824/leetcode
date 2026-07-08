package org.example.archive.hot100.recursion;

//给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
//
// 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3ˣ
//
//
//
// 示例 1：
//
//
//输入：n = 27
//输出：true
//
//
// 示例 2：
//
//
//输入：n = 0
//输出：false

public class _326 {

    public static void main(String[] args) {
        System.out.println(_326.isPowerOfThree(27));
        System.out.println(_326.isPowerOfThree(45));
        System.out.println(_326.isPowerOfThree(1));
        System.out.println(_326.isPowerOfThree(0));
        System.out.println(_326.isPowerOfThree(-3));
    }

    public static boolean isPowerOfThree(int n) {
        if (n == 3 || n == 1) {
            return true;
        }
        if (n % 3 != 0 || n == 0) {
            return false;
        }
        return isPowerOfThree(n / 3);
    }

}
