package org.example.offer;

public class FibonaciArray {
    /*
        NO.07
        输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。n<=39
     */

    public static int Fibonacci(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return Fibonacci(n-1) + Fibonacci(n-2);
    }

    public static void main(String[] args) {
        System.out.println(Fibonacci(7));
    }
}
