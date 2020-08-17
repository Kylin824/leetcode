package org.example.leetcode.math;

public class BinnarySum {

    /*
    67.二进制求和

    给你两个二进制字符串，返回它们的和（用二进制表示）。
    输入为 非空 字符串且只包含数字 1 和 0。

    输入示例!  Long放不下
    "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101"
    "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"
     */


    public static String qs(String a, String b) {
        int ea = a.length() - 1;
        int eb = b.length() - 1;
        StringBuilder ret = new StringBuilder();
        int carry = 0;
        while (ea >= 0 && eb >= 0) {
            if (a.charAt(ea) == '1' && b.charAt(eb) == '1') {
                if (carry == 1) {
                    ret.append('1');
                }
                else {
                    ret.append('0');
                    carry = 1;
                }
            }
            else if (a.charAt(ea) == '1' || b.charAt(eb) == '1'){
                if (carry == 1) {
                    ret.append('0');
                }
                else {
                    ret.append('1');
                    carry = 0;
                }
            }
            else {
                if (carry == 1) {
                    ret.append('1');
                    carry = 0;
                }
                else {
                    ret.append('0');
                }
            }
            ea--;
            eb--;
        }
        while (ea >= 0) {
            if (a.charAt(ea) == '0') {
                ret.append(carry);
                carry = 0;
            }
            else {
                if (carry == 1) {
                    ret.append('0');
                }
                else {
                    ret.append('1');
                    carry = 0;
                }
            }
            ea--;
        }

        while (eb >= 0) {
            if (b.charAt(eb) == '0') {
                ret.append(carry);
                carry = 0;
            }
            else {
                if (carry == 1) {
                    ret.append('0');
                }
                else {
                    ret.append('1');
                    carry = 0;
                }
            }
            eb--;
        }
        if (carry == 1)
            ret.append('1');
        return ret.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "1111111";
        String b = "100101";
        Long aint = Long.parseLong(a, 2);
        Long bint = Long.parseLong(b, 2);
        System.out.println(Long.toBinaryString(aint+bint));

        System.out.println(qs(a, b));
    }
}
