package org.example.huawei;

import javafx.beans.binding.BooleanExpression;

import java.util.*;

public class ProblemThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] start = new int[n];
        int[] end = new int[n];
        int[] station = new int[10000];
        Map<Integer, Integer> distance = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            start[i] = sc.nextInt();
            end[i] = sc.nextInt();
            distance.put(end[i] - start[i], i);
        }

        Set<Integer> dset = distance.keySet();
        int seat = 0;
        for (Integer d : dset) {
//            System.out.println( d + " " + distance.get(d));
            int index = distance.get(d);
            int tou = start[index];
            int wei = end[index];
            boolean flag = true;
            for (int i = tou; i <= wei; i++) {
                if (station[i] == 0) {
                    station[i] = 1;
                }
                else {
                    flag = false;
                }
            }

            if (!flag) {
                seat++;
            }
        }

        System.out.println(seat);
    }
}
