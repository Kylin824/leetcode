package org.example.company.huawei.array;

import java.security.interfaces.ECKey;
import java.util.Scanner;

public class CountNegative {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int posCount = 0;
            int negCount = 0;
            int sum = 0;
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                int tmp = sc.nextInt();
                if (tmp > 0) {
                    posCount++;
                    sum += tmp;
                } else if (tmp < 0){
                    negCount++;
                }
            }
            System.out.print(negCount + " ");
            System.out.printf("%.1f",  (float)sum / posCount);
            System.out.println();
        }
    }
}
