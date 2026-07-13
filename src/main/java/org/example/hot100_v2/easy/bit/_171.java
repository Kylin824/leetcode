package org.example.hot100_v2.easy.bit;

/**
 * @author kylin
 * @date 2026/7/13
 */
public class _171 {

    public static int titleToNumber(String columnTitle) {
        int sum = 0;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            int num = columnTitle.charAt(i) - 'A' + 1;
            sum += (int) (num * Math.pow(26, columnTitle.length() - i - 1));
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("ZY"));
    }
}
