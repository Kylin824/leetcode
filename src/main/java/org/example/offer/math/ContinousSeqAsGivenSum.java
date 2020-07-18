package org.example.offer.math;

import java.util.ArrayList;

public class ContinousSeqAsGivenSum {
    /*
        NO.41
        小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
        但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
        没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
        找出所有和为S的连续正数序列
        例如:
            给定100
            9,10,11,12,13,14,15,16 连续和为100
            18,19,20,21,22 连续和为100
     */
    /*
        思路:
            滑动窗口, 用一个数存窗口内的总和，如果小于目标值，则窗口右扩，大于目标值则窗口左减，直到窗口左边超过sum/2
     */
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        int left = 1;
        int right = 1;
        int sumOfWindow = 0;
        while (left <= sum / 2) {
            if (sumOfWindow < sum) {
                sumOfWindow += right;
                right++; // 窗口右增
            }
            else if (sumOfWindow > sum) {
                sumOfWindow -= left;
                left--; // 窗口左减
            }
            else {
                ArrayList<Integer> seq = new ArrayList<>();
                for (int i = left; i < right; i++)  {
                    seq.add(i);
                }
                ret.add(seq);
                sumOfWindow -= left;
                left++; // 窗口左减
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> ret = FindContinuousSequence(3);
        System.out.println("end");
    }

}
