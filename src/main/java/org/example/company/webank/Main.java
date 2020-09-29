package org.example.company.webank;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int q = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            for (int i = 0; i < q; i++) {
                int queryNum = sc.nextInt();
                if (queryNum <= arr[0]) {
                    System.out.println(arr[0]);
                    continue;
                }
                if (queryNum >= arr[n - 1]) {
                    System.out.println(arr[n - 1]);
                    continue;
                }
                int index = binarySearch(arr, queryNum);
                if (Math.abs(arr[index] - queryNum) <= Math.abs(arr[index + 1] - queryNum))
                    System.out.println(arr[index]);
                else {
                    System.out.println(arr[index + 1]);
                }
            }
        }
    }

    public static int binarySearch(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] < target) {
                low = mid + 1;
            }
            else if (array[mid] > target) {
                high = mid - 1;
            }
            else {
                return mid;
            }
        }
        return high;
    }
}
