package org.example.company.webank;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            int n = sc.nextInt();
            int m = sc.nextInt();
            int q = sc.nextInt();
            for (int i = 0; i < q; i++) {
                int rawX = sc.nextInt();
                int rawY = sc.nextInt();
                int tmp = 0;
                // 顺时针
                if (x % 4 == 1) {
                    tmp = rawX;
                    rawX = rawY;
                    rawY = n + 1 - tmp;
                }
                else if (x % 4 == 2) {
                    rawX = n + 1 - rawX;
                    rawY = m + 1 - rawY;
                }
                else if (x % 4 == 3) {
                    tmp = rawY;
                    rawY = rawX;
                    rawX = m + 1 - tmp;
                }

                // 水平翻转
                if (y % 2 == 1) {
                    if (x % 2 == 0) {
                        rawY = m + 1 - rawY;
                    }
                    else {
                        rawY = n + 1 - rawY;
                    }
                }

                // 逆时针
                if (z % 4 == 1) {
                    tmp = rawY;
                    rawY = rawX;
                    rawX = n + 1 - tmp;
                }
                else if (z % 4 == 2) {
                    rawX = n + 1 - rawX;
                    rawY = m + 1 - rawY;
                }
                else if (z % 4 == 3) {
                    tmp = rawX;
                    rawX = rawY;
                    rawY = m + 1 - tmp;
                }
                System.out.println(rawX + " " + rawY);
            }
        }
    }
}
