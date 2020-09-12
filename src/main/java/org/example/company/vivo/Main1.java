package org.example.company.vivo;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int startX = sc.nextInt();
            int startY = sc.nextInt();
            int endX = sc.nextInt();
            int endY = sc.nextInt();

            char[][] mat = new char[n][n];
            for (int i = 0; i < n; i++) {
                mat[i] = sc.next().toCharArray();
            }

            int[][] path = new int[n][n];
            System.out.println(Math.abs(startX - endX) + Math.abs(startY - endY));
        }
    }
}
