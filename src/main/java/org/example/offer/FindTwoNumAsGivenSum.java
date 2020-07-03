package org.example.offer;

import java.util.ArrayList;
import java.util.Arrays;

public class FindTwoNumAsGivenSum {
    /*
        NO.42
        输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
     */
    public static ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (array.length <= 0)
            return ret;
        int i = 0, j = array.length - 1, tmp = Integer.MAX_VALUE;
            while (i < j) {
                if (array[i] + array[j] == sum) {
                    if (array[i] * array[j] < tmp) {
                        ret.add(array[i]); // 小的在前
                        ret.add(array[j]); // 大的在后
                        tmp = array[i] * array[j];
                    }
                    i++;
                    j--;
                }
                else if (array[i] + array[j] < sum) {
                    i++;
                }
                else {
                    j--;
                }
            }
        return ret;
    }

    public static void main(String[] args) {
        int[] arr  = {1,2,3,4,5,6,7,8,9};
        ArrayList<Integer> res = FindNumbersWithSum(arr, 11);
        System.out.println(Arrays.toString(res.toArray()));
    }
}
