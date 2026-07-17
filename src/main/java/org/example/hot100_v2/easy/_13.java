package org.example.hot100_v2.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字转整数
 * @author kylin
 * @date 2026/7/18
 */

public class _13 {

    Map<Character, Integer> map = new HashMap<Character, Integer>() {
        {
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }
    };

    public int romanToInt(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i < s.length() - 1) {
                if (map.get(c) < map.get(s.charAt(i + 1))) {
                    sum -= map.get(c);
                } else {
                    sum += map.get(c);
                }
            } else {
                sum += map.get(c);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        _13 obj = new _13();
        System.out.println(obj.romanToInt("LVIII"));
        System.out.println(obj.romanToInt("MCMXCIV"));
    }
}
