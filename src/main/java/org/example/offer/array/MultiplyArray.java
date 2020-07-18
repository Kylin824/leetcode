package org.example.offer.array;

public class MultiplyArray {
    /*
        NO.51
        给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
        不能使用除法。（注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
     */
    /*
        思路:
            1. 双重循环 O(n^2)

            2. 分析

            B[0]   =    1  x  A[1] x  A[2]  x  A[3]  x ... x  A[n-1]
            B[1]   =  A[0] x   1   x  A[2]  x  A[3]  x ... x  A[n-1]
            B[2]   =  A[0] x  A[1] x   1    x  A[3]  x ... x  A[n-1]
            B[3]   =  A[0] x  A[1] x  A[2]  x   1    x ... x  A[n-1]
            ...
            B[n-1] =  A[0] x  A[1] x  A[2]  x  A[3]  x ... x    1

            所以先计算B数组的所有左边部分  然后计算B的所有右边部分
     */
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        B[0] = 1;
        for (int i = 1; i < B.length; i++) {
            B[i] = B[i-1] * A[i-1];
        }
        int tmp = 1;
        for (int i = A.length - 2; i >= 0; i--) {
            tmp = tmp * A[i+1];
            B[i] *= tmp;
        }
        return B;
    }

}
