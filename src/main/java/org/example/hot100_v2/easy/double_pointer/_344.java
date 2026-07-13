package org.example.hot100_v2.easy.double_pointer;

/**
 * @author kylin
 * @date 2026/7/13
 */
public class _344 {
    public void reverseString(char[] s) {
        int i = 0, j = s.length - 1;
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }
}
