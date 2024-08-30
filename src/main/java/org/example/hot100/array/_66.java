package org.example.hot100.array;

import java.util.Arrays;

/**
 * @author kylin
 * @date 2024/8/30
 */
public class _66 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(_66.plusOne(new int[]{9})));;
    }

    public static int[] plusOne(int[] digits) {
        int add = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int ge = (digits[i] + add) % 10;
            add = (digits[i] + add) / 10;
            digits[i] = ge;
        }
        if (add > 0) {
            int [] res = new int[digits.length + 1];
            res[0] = 1;
            for (int i = 1; i < res.length; i++) {
                res[i] = digits[i - 1];
            }
            return res;
        }
        return digits;
    }

}
