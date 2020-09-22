package org.example.company.hm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 8 1 2 2 3
        // 4 0 1 1 3

        // 1 2 2 3 8
        // 0 1 1 3 4

        int[] arr = {8, 1, 2, 2, 3};
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    count++;
                }
            }
            System.out.print(count + " ");
        }
    }
}
