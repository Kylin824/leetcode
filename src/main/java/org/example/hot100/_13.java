package org.example.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kylin
 * @date 2024/8/29
 */
public class _13 {

    public static void main(String[] args) {
        String s = "CMXCIX"; // 999
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int res = map.get(s.charAt(0)), last = map.get(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            Integer cur = map.get(s.charAt(i));
            if (last < cur) {
                res -= last;
                res += cur - last;
            } else {
                res += cur;
            }
            last = cur;
        }
        System.out.println(res);
    }
}
