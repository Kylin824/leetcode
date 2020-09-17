package org.example.company.hm;

import java.util.HashSet;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            if (start == end) {
                System.out.println(start);
                continue;
            }
            int bian = sc.nextInt();
            HashSet<Integer> sset = new HashSet<>();
            HashSet<Integer> eset = new HashSet<>();
            int startCount = 0, endCount = 0;
            for (int i = 0; i < bian; i++) {
                int s = sc.nextInt();
                int e = sc.nextInt();
                if (s == start || e == start) {
                    startCount++;
                    sset.add(s == start ? e : s);
                }
                if (s == end || e == end) {
                    endCount++;
                    eset.add(s == end ? e : s);
                }
            }
            if (startCount != endCount) {
                System.out.println(0);
            }
            else {
                sset.addAll(eset);
                int sum = 0;
                for (int i : sset) {
                    sum += i;
                }
                System.out.println(sum);
            }
        }
    }
}
