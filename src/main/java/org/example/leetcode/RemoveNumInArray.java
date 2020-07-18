package org.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class RemoveNumInArray {
    /*
        LC123 给定一个数组和一个值，使用就地算法将数组中所有等于这个值的元素删除，并返回新数组的长度。
     */
    public static int removeElement(int[] A, int elem) {
        int[] tmp = Arrays.stream(A).filter(x -> x!=elem).toArray();
        System.arraycopy(tmp, 0, A, 0, tmp.length);
        return A.length;
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,4};
        int ret = removeElement(A, 1);
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
    }

}
