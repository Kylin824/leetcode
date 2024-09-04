package org.example.hot100.two_pointer;

/**
 * @author kylin
 * @date 2024/9/4
 */
public class _387 {

    public static void main(String[] args) {
//        System.out.println(_387.firstUniqChar("leetcode"));
//        System.out.println(_387.firstUniqChar("aabb"));
        System.out.println(_387.firstUniqChar("loveleetcode"));
    }

    public static int firstUniqChar(String s) {
        int i = 0, j;
        while (i < s.length()) {
            j = 0;
            while (j < s.length()) {
                if (i != j && s.charAt(i) == s.charAt(j)) {
                    break;
                }
                j++;
            }
            if (j == s.length()) {
                return i;
            }
            i++;
        }
        return -1;
    }

}
