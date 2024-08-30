package org.example.hot100.two_pointer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kylin
 * @date 2024/8/30
 */
public class _125 {

    public static void main(String[] args) {
        System.out.println(_125.isPalindrome("abb"));
    }

    public static boolean isPalindrome(String s) {
        List<Character> cs = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 48 && c <= 57) {
                cs.add(c);
            }
            if (c >= 65 && c <= 90) {
                cs.add((char) (c + 32));
            }
            if (c >= 97 && c <= 122) {
                cs.add(c);
            }
        }
        if (cs.isEmpty()) {
            return true;
        }
        int i = 0;
        int j = cs.size() - 1;
        while (i < j) {
            if (cs.get(i) != cs.get(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
