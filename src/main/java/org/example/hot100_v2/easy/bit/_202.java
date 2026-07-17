package org.example.hot100_v2.easy.bit;

import java.util.HashSet;
import java.util.Set;

/**
 * @author kylin
 * @date 2026/7/18
 */

public class _202 {

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            int sum = 0;
            while (n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }
            n = sum;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        _202 obj = new _202();
        System.out.println(obj.isHappy(1));
        System.out.println(obj.isHappy(19));
        System.out.println(obj.isHappy(2));
    }
}
