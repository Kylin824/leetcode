package org.example.company.basic;

public class QuickSortTopK {
    /*
    有一个整数数组，请你根据快速排序的思路，找出数组中第K大的数。

    给定一个整数数组a,同时给定它的大小n和要找的K(K在1到n之间)，请返回第K大的数，保证答案存在。

    测试样例：
    [1,3,5,2,2],5,3
    返回：2
     */
    public static int findKth(int[] a, int n, int K) {
        return quickSort(a, 0, n - 1, K);
    }
    public static int quickSort(int[] a, int low, int high, int K) {

        if (low >= high)
            return 0;

        int i = low, j = high, tmp = a[low];

        while (i < j) {
            while (i < j && a[j] >= tmp) {
                j--;
            }
            a[i] = a[j];
            while (i < j && a[i] <= tmp) {
                i++;
            }
            a[j] = a[i];
        }
        a[i] = tmp;

        if (i - low + 1 == K)
            return a[i];
        else if (i - low + 1 < K) {
            return quickSort(a, i + 1, high, K - i + low - 1);
        }
        else {
            return quickSort(a, low, i - 1, K);
        }
    }

    public static void main(String[] args) {
        int[] a = {1,3,5,2,2};

        System.out.println(findKth(a, 5, 3));
    }
}
