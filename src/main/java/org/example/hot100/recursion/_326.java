package org.example.hot100.recursion;

/**
 * @author kylin
 * @date 2024/9/3
 */
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
