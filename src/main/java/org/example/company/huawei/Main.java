package org.example.company.huawei;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] flag = new int[n];
        for (int i = 0; i < n; i++) {
            flag[i] = 1;
            int pages = sc.nextInt();
            int[] arr = new int[pages];
            for (int j = 0; j < pages; j++) {
                arr[j] = sc.nextInt();
            }
            int count = 0;
            int min = 0;
            for (int k = 0; k < arr.length; k++) {
                count++;
                min += arr[k];
                if (count >= 4 && min <= 60) {
                    flag[i] = 0;
                    break;
                } else if (count <= 4 && min > 60) {
                    min = min % 60;
                    count = 0;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(flag[i]);
        }

        System.out.println(3/2);
    }
}
