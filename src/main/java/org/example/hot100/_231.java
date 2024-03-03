package org.example.hot100;

//给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
//
// 如果存在一个整数 x 使得 n == 2ˣ ，则认为 n 是 2 的幂次方。
//
//
//
// 示例 1：
//
//
//输入：n = 1
//输出：true
//解释：2⁰ = 1
//
//
// 示例 2：
//
//
//输入：n = 16
//输出：true
//解释：2⁴ = 16
//
//
// 示例 3：
//
//
//输入：n = 3
//输出：false
//
//
// 示例 4：
//
//
//输入：n = 4
//输出：true
//
//
// 示例 5：
//
//
//输入：n = 5
//输出：false
//
//
//
//
// 提示：
//
//
// -2³¹ <= n <= 2³¹ - 1
//
//
//
//
// 进阶：你能够不使用循环/递归解决此问题吗？
//
// Related Topics 位运算 递归 数学 👍 665 👎 0

public class _231 {

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        return isPowerOfTwo(n >>> 1) && n % 2 == 0;
    }

    public static void main(String[] args) {
        _231 a = new _231();
        System.out.println(a.isPowerOfTwo(0));
        System.out.println(a.isPowerOfTwo(1));
        System.out.println(a.isPowerOfTwo(2));
        System.out.println(a.isPowerOfTwo(3));
        System.out.println(a.isPowerOfTwo(4));
        System.out.println(a.isPowerOfTwo(5));
        System.out.println(a.isPowerOfTwo(6));
        System.out.println(a.isPowerOfTwo(7));
        System.out.println(a.isPowerOfTwo(8));
        System.out.println(a.isPowerOfTwo(-2147483648));
    }
}
