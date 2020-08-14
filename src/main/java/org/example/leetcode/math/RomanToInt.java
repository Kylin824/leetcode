package org.example.leetcode.math;

import scala.Int;

import java.util.HashMap;

public class RomanToInt {
    /*
        13. 罗马数字转整数
        I             1
        V             5
        X             10
        L             50
        C             100
        D             500
        M             1000

        I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
        X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
        C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。

     */

    private static HashMap<Character, Integer> map = new HashMap<Character, Integer>(){{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public static int romanToInt(String s) {
        int sum = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            Character ch = s.charAt(i);
            Character next = s.charAt(i + 1);
            if (ch == 'I' && (next == 'V' || next == 'X')) {
                sum -= 1;
            }
            else if (ch == 'X' && (next == 'L' || next == 'C')) {
                sum -= 10;
            }
            else if (ch == 'C' && (next == 'D' || next == 'M')) {
                sum -= 100;
            }
            else {
                sum += map.get(ch);
            }
        }
        sum += map.get(s.charAt(s.length() - 1));
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
}
