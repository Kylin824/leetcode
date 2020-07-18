package org.example.leetcode;

import java.util.LinkedList;

public class ReverseInteger {
    /*
        LC142 将给出的整数x翻转。
        边界条件判断
     */

    public static int reverse (int x) {
        boolean positive = x > 0;
        if (!positive) x = -x;
        LinkedList<Integer> bits = new LinkedList<>();
        int i = 0;
        while (x != 0) {
            bits.add(x % 10);
            x = x / 10;
            i++;
        }
        long tmp = 0L;
        for (int j = 0; j < bits.size(); j++) {
            tmp += bits.get(j) * Math.pow(10, bits.size() - 1 - j);
        }
        if (!positive) tmp = -tmp;
        if (tmp > Integer.MAX_VALUE || tmp < Integer.MIN_VALUE)
            return 0;
        else
            return (int)tmp;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(reverse(-123));
    }
}
