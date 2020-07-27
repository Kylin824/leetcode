package org.example.company.huawei.array;

import java.util.Scanner;

public class SnakeMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int sum = n * (n + 1) / 2;
            int r = 0;
            int c = 0;
            int rr = 1;
            for (int i = 1; i <= sum; i++) {
                matrix[r][c] = i;
                // 第一行，直接跳左下
                if (r == 0) {
                    r += rr;
                    c = 0;
                    rr++;
                }
                // 非第一行，右上
                else {
                    r--;
                    c++;
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n - i; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
