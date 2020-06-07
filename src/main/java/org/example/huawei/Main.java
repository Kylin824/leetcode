package org.example.huawei;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();


        int max_r = 0;
        int max_l = 0;

        int[][] input = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                input[i][j] = (i+1) * (j+1) % 10;
                if (input[i][j] == 9) {
                    max_r = i;
                    max_l = j;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(input[i][j] + " ");
            }
            System.out.println();
        }

        int[][] pooled = new int[n-a+1][m-b+1];

//        int count = 0;
//        for (int i = 0; i < n-a+1; i++) {
//            for (int j = 0; j < m-b+1; j++) {
//                count++;
//            }
//        }

        int count = (n-a+1) * (m-b+1);
//        System.out.println(count);
        int sum = 0;

        for (int c = 0; c < count; c++) {
            int max = 0;
            int r = 0;
            int l = 0;

            if (c % (n-a+1) <=max_r && c % (n-a+1) + a - 1 >= max_r
                    && c % (m-b+1) <= max_l && c % (m-b+1) + b - 1 >= max_l) {
                pooled[c % (n-a+1)][c % (m-b+1)] = 9;
            }
            else {
                for (r = c % (n-a+1); r < c % (n-a+1) + a; r++) {
                    for (l = c % (m-b+1); l < c % (m-b+1) + b; l++) {

                        if (input[r][l] > max) {
                            max = input[r][l];
                        }
                    }
                }
                pooled[c % (n-a+1)][c % (m-b+1)] = max;
            }
            sum += pooled[c % (n-a+1)][c % (m-b+1)];
        }

        System.out.println(sum);
    }

}
