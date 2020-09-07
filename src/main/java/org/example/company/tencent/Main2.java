package org.example.company.tencent;

import java.util.*;
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int n = sc.nextShort();
            int m = sc.nextInt();
            boolean[][] matrix = new boolean[n + 1][n + 1];
            int zero = 0;
            int num, tmp;
            for (int i = 0; i < m; i++) {
                num = sc.nextInt();
                int[] map = new int[num];
                for (int j = 0; j < num; j++) {
                    tmp = sc.nextInt();
                    if (tmp == 0)
                        zero++;
                    map[j] = tmp;
                }
                for (int j = 0; j < num; j++) {
                    for (int k = 0; k < num; k++) {
                        if (k == j)
                            continue;
                        matrix[map[j]][map[k]] = true;
                    }
                }
            }
            if (zero <= 0) {
                System.out.println(0);
                return;
            }
            HashSet<Integer> set = new HashSet<>();
            ArrayList<Integer> q = new ArrayList<>();
            q.add(0);
            set.add(0);
            while (q.size() > 0) {
                int cur = q.remove(0);
                for (int i = 0; i < n + 1; i++) {
                    if (matrix[cur][i]) {
                        matrix[cur][i] = false;
                        q.add(i);
                        set.add(i);
                    }
                }
            }
            System.out.println(set.size());
        }
    }
}