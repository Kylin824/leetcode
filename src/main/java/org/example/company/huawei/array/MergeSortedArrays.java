package org.example.company.huawei.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MergeSortedArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] arr1 = new int[n];
            for (int i = 0; i < n; i++) {
                arr1[i] = sc.nextInt();
            }
            int m = sc.nextInt();
            int[] arr2 = new int[m];
            for (int i = 0; i < m; i++) {
                arr2[i] = sc.nextInt();
            }

            Arrays.sort(arr1);
            Arrays.sort(arr2);

            // merge
            int p1 = 0;
            int p2 = 0;
            while (p1 < arr1.length && p2 < arr2.length) {
                if (arr1[p1] < arr2[p2]) {
                    System.out.print(arr1[p1]);
                    p1++;
                }
                else if (arr1[p1] == arr2[p2]) {
                    System.out.print(arr1[p1]);
                    p1++;
                    p2++;
                }
                else {
                    System.out.print(arr2[p2]);
                    p2++;
                }
            }
            if (p1 >= arr1.length) {
                while (p2 < arr1.length) {
                    System.out.print(arr2[p2]);
                    p2++;
                }
            }
            else {
                while (p1 < arr1.length) {
                    System.out.print(arr1[p1]);
                    p1++;
                }
            }
        }
    }
}
