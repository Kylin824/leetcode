package org.example.leetcode;

public class NumAppearOnceInArray {
    /*
        LC15 现在有一个整数类型的数组，数组中素只有一个元素只出现一次，其余的元素都出现两次。
     */

    public int singleNumber (int[] A) {
        if (A.length <= 0)
            return 0;
        int ret = A[0];
        for (int i = 1; i < A.length; i++) {
            ret = ret ^ A[i];
        }
        return ret;
    }
}
