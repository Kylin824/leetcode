package org.example.interview.bit;

public class ReverseBits {
    /*
    面试题 05.03. 翻转数位
    给定一个32位整数 num，你可以将一个数位从0变为1。
    请编写一个程序，找出你能够获得的最长的一串1的长度。
     */

    public static int reverseBits(int num) {
        char[] chars = Integer.toBinaryString(num).toCharArray();
        int max = 0;
        int preNumOfOne = 0;
        int postNumOfOne = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1') {
                preNumOfOne++;
            } else {
                for (int j = i + 1; j < chars.length; j++) {
                    if (chars[j] == '1')
                        postNumOfOne++;
                    else {
                        max = Math.max(max, preNumOfOne + postNumOfOne + 1);
                        preNumOfOne = 0;
                        postNumOfOne = 0;
                        break;
                    }
                }
            }
        }
        max = Math.max(max, preNumOfOne + postNumOfOne + 1);
        return max;
    }

    public static int reverseBitsOpt(int num) {
        int max = 0;
        int rightOneOfCur = 0; // 当前0的右边1个数 <==> 上一个0的左边1的个数）
        int lastRightOneOfCur = 0; // 上一个0的右边1的个数

        while (num != 0) {
            if ((num & 1) != 0) { // 最后一位为1
                rightOneOfCur++;
            }
            else { // 最后一位为0
                max = Math.max(max, rightOneOfCur + lastRightOneOfCur + 1);
                lastRightOneOfCur = rightOneOfCur;
                rightOneOfCur = 0;
            }
            num = num >> 1; // 右移
        }
        max = Math.max(max, rightOneOfCur + lastRightOneOfCur + 1);
        return max;
    }

    public static void main(String[] args) {
        System.out.println(reverseBits(7));
        System.out.println(~2147483647);
    }
}
