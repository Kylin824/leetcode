package org.example.interview.bit;

public class InsertBits {
    public static int insertBits(int N, int M, int i, int j) {

        int tmp = Integer.MAX_VALUE;
        int n = 1;
        for (int k = 0; k < i; k++) {
            n = n << 1;
        }
        for (int k = i; k <= j; k++) { // 目的是让N中的第i到第j位变为0
            int r = ~n;
            tmp = tmp & r;
            n = n << 1;
        }
        N = N & tmp;
        return N + (M << i);
    }

    public static int insertBits1(int N, int M, int i, int j) {
        // N的i到j位变为0
        // 000001000 -- -1 --> 000000111 -- <<i --> 000011100 -- ~ --> 111100011
        int tmp = ~((1 << (j - i + 1)) - 1 << i);
        N = N & tmp;
        return N | (M << i); // 用 | 比 + 更快
    }

    public static void main(String[] args) {
        System.out.println(19 << 2);
        System.out.println(insertBits1(1143207437, 1017033, 11, 31));
    }
}
