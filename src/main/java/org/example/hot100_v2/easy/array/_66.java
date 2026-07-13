package org.example.hot100_v2.easy.array;

import java.util.Arrays;

/**
 * @author kylin
 * @date 2026/7/14
 */

public class _66 {

    public static int[] plusOne(int[] digits) {
        int[] res = new int[digits.length + 1];
        int carry = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            int num = digits[i] + carry;
            if (i == digits.length - 1) {
                num += 1;
            }
            if (num > 9) {
                carry = 1;
                res[i + 1] = num % 10;
            } else {
                carry = 0;
                res[i + 1] = num;
            }
        }
        if (carry > 0) {
            res[0] = carry;
        }
        return carry == 1 ? res : Arrays.copyOfRange(res, 1, res.length);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{4,3,2,1})));
        System.out.println(Arrays.toString(plusOne(new int[]{9,9,9})));
    }
}
