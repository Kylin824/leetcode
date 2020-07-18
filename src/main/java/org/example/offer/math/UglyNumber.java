package org.example.offer.math;

import java.util.ArrayList;

public class UglyNumber {
    /*
        NO.32
        只包含质因子2、3和5的数称作丑数（Ugly Number）。
        例如6、8都是丑数，但14不是，因为它包含质因子7。
        习惯上我们把1当做是第一个丑数。
        求按从小到大的顺序的第N个丑数。
     */
    /*
        思路
            丑数*2 *3 *5也是丑数
     */

    public static int getUglyNumber(int index) {
        if (index <= 0)
            return 0;
        int[] uglyNums = new int[index];
        int p2 = 0, p3 = 0, p5 = 0;
        uglyNums[0] = 1;
        for (int i = 1; i < index; i++) {
            int newUglyNum = Math.min(Math.min(uglyNums[p2] * 2, uglyNums[p3] * 3), Math.min(uglyNums[p2] * 3, uglyNums[p5] * 5));
            uglyNums[i] = newUglyNum;
            if (newUglyNum % 2 == 0)
                p2++;
            if (newUglyNum % 3 == 0)
                p3++;
            if (newUglyNum % 5 == 0)
                p5++;
        }
        return uglyNums[index - 1];
    }


    public static void main(String[] args) {
        System.out.println(getUglyNumber(9));
    }
}
