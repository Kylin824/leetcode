package org.example.leetcode.math;

import java.util.Arrays;

public class PlusOne {
    /*
    66. 加一
    给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

    最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

    你可以假设除了整数 0 之外，这个整数不会以零开头。

    示例 1:
    输入: [1,2,3]
    输出: [1,2,4]
    解释: 输入数组表示数字 123。

    示例 2:
    输入: [4,3,2,1]
    输出: [4,3,2,2]
    解释: 输入数组表示数字 4321。
     */

    public static int[] qs(int[] digits) {
        int carry = 0;
        int[] ret = new int[digits.length + 1];
        for (int i = ret.length - 1; i > 0; i--) {
            ret[i] = digits[i - 1];
        }

        if (ret[ret.length - 1] == 9) {
            ret[ret.length - 1] = 0;
            carry = 1;
        }
        else {
            ret[ret.length - 1] += 1;
        }
        for (int i = ret.length - 2; i >= 0; i--) {
            if (ret[i] == 9) {
                if(i == ret.length - 1) {
                    carry = 1;
                    ret[i] = 0;
                }
                else if(carry == 1) {
                    ret[i] = 0;
                }
            }
            else {
                ret[i] += carry;
                if (carry == 1)
                    carry = 0;
            }
        }
        if (ret[0] == 0) {
            return Arrays.copyOfRange(ret, 1, ret.length);
        }
        return ret;
    }

    public static void main(String[] args) {
//        int[] input = {9,8,7,6,5,4,3,2,1,0};
        int[] input = {9,9,9};
        System.out.println(Arrays.toString(qs(input)));
    }
}
