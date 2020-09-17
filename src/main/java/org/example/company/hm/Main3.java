package org.example.company.hm;

import scala.Int;

import java.util.*;

public class Main3 {

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
            int[][] map = new int[101][101];
            int[] visitedStart = new int[101];
            int[] visitedEnd = new int[101];
            for (int i = 0; i < bian; i++) {
                int s = sc.nextInt();
                int e = sc.nextInt();
                map[s][e] = 1;
                map[e][s] = 1;
            }

            StringBuilder sb1 = new StringBuilder();
            Queue<Integer> queue1 = new LinkedList<>();
            queue1.add(start);
            visitedStart[start] = 1;
            while (!queue1.isEmpty()) {
                int cur = queue1.poll();
                visitedStart[cur] = 1;
                sb1.append(cur).append(" ");
                for (int i = 0; i < 101; i++) {
                    if (map[cur][i] == 1 && visitedStart[i] != 1) {
                        queue1.add(i);
                        visitedStart[i] = 1;
                    }
                }
            }

            StringBuilder sb2 = new StringBuilder();
            Queue<Integer> queue2 = new LinkedList<>();
            queue2.add(end);
            visitedEnd[end] = 1;
            while (!queue2.isEmpty()) {
                int cur = queue2.poll();
                visitedEnd[cur] = 1;
                sb2.append(cur).append(" ");
                for (int i = 0; i < 101; i++) {
                    if (map[cur][i] == 1 && visitedEnd[i] != 1) {
                        queue2.add(i);
                        visitedEnd[i] = 1;
                    }
                }
            }

            // System.out.println(sb1.toString().trim());
            // System.out.println(sb2.reverse().toString().trim());
            String[] s1 = sb1.toString().trim().split(" ");
            int[] n1 = new int[s1.length];
            int i = 0;
            for (String s : s1) {
                n1[i++] = Integer.parseInt(s);
            }
            String[] s2 = sb2.toString().trim().split(" ");
            int[] n2 = new int[s2.length];
            i = 0;
            for (String s : s2) {
                n2[i++] = Integer.parseInt(s);
            }
            int flag = 1;
            for (int j = 1; j < n1.length - 1; j++) {
                if (n1[j] == n2[n1.length - 1 - j] && n1[n1.length - 1 - j] != n2[j]) {
                    System.out.println(0);
                    flag = 0;
                    break;
                }
            }
            if (flag == 1) {
                int sum = 0;
                for (int j = 1; j < n1.length - 1; j++) {
                    if (n1[j] == n2[j]) {
                        sum += n1[j];
                    }
                }
                System.out.println(sum);
            }
        }
    }
}
