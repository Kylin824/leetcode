package org.example.leetcode.math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SequenceAsSum {
    /*

    示例 1：

    输入：target = 9
    输出：[[2,3,4],[4,5]]

    思路:
            滑动窗口, 用一个数存窗口内的总和，如果小于目标值，则窗口右扩，大于目标值则窗口左减，直到窗口左边超过sum/2
     */
    public static int[][] findContinuousSequence(int target) {
        List<int[]> ret = new ArrayList<>();
        int lw = 1;
        int rw = 1; // 先加，后右移
        int sum = 0;
        while (lw <= target / 2) {
            // 右扩
            if (sum < target) { // 先加，后右移
                sum += rw;
                rw++;
            }
            // 左缩
            else if (sum > target) {
                sum -= lw;
                lw++;
            }
            // 等于sum
            else {
                int[] seq = new int[rw - lw];
                for (int i = lw; i < rw; i++) {
                    seq[i - lw] = i;
                }
                ret.add(seq);
                sum -= lw;
                lw++;
            }
        }
        return ret.toArray(new int[0][]);
    }

    public static int[][] findContinuousSequence1(int target) {

        List<int[]> result = new ArrayList<>();
        int i = 1;

        while (target > 0) {
            target -= i;
            i++;
            if (target > 0 && target % i == 0) {
                int[] array = new int[i];
                for (int k = target / i, j = 0; k < target / i + i; k++, j++) {
                    array[j] = k;
                }
                result.add(array);
            }
        }
        Collections.reverse(result);
        return result.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] res = findContinuousSequence1(15);
        System.out.println("test");
    }
}
