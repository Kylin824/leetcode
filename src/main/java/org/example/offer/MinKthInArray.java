package org.example.offer;

import java.util.ArrayList;
import java.util.Arrays;

public class MinKthInArray {
    /*
        NO.29
        输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
     */
    /*
        思路:
            堆排
            1. 从第 i/2个节点开始调整成最小堆
            2. 交换首尾节点
            3. 再次调整成最小堆

            特判：k超过数组长度的情况
     */
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (k > input.length) {
            return ret;
        }
        for (int i = input.length / 2 - 1; i >= 0; i--) {
            smallHeapAdjust(input, i, input.length);
        }
        for (int i = input.length - 1; i > input.length -1 - k; i--) {

            // 交换首尾节点
            int tmp = input[0];
            input[0] = input[i];
            input[i] = tmp;

            ret.add(input[i]);

            // 再次调整最小堆
            smallHeapAdjust(input, 0, i);
        }
        return ret;
    }

    public static void smallHeapAdjust(int[] arr, int root, int end) {
        int val = arr[root];
        for (int i = 2*root+1; i < end; i = 2*i+1) {
            if (i+1 < end && arr[i] > arr[i+1])
                i++;
            if (val < arr[i]) //根最小 不用交换
                break;
            else {
                arr[root] = arr[i];
                root = i; //
            }
        }
        arr[root] = val;
    }

    public static void main(String[] args) {
        int[] array = {4,5,1,6,2,7,3,8};
        ArrayList<Integer> ret = GetLeastNumbers_Solution(array, 4);
        System.out.println(Arrays.toString(ret.toArray()));
    }
}
