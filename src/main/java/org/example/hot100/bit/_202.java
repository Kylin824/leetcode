package org.example.hot100.bit;

import java.util.HashSet;

/**
 * @author kylin
 * @date 2024/8/31
 */
public class _202 {

    public static void main(String[] args) {
        System.out.println(_202.isHappy(19));
    }

    public static boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        int tmp = 0;
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            while (n > 0) {
                int b = n % 10;
                tmp += b * b;
                n = n / 10;
            }
            n = tmp;
            tmp = 0;
        }
        return n == 1;
    }

}
