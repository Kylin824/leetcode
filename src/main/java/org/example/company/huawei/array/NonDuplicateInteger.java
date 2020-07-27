package org.example.company.huawei.array;

import java.util.Scanner;

public class NonDuplicateInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] map = new int[10];
            int ret = 0;
            while (n != 0) {
                int tmp = n % 10;
                if (map[tmp] == 0) {
                    map[tmp]++;
                    ret = ret * 10 + tmp;
                }
                n = n / 10;
            }
            System.out.println(ret);
        }
    }
}
