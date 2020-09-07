package org.example.company.tencent;

import java.util.*;
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int n = sc.nextInt();
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                set.add(sc.nextInt());
            }
            int n2 = sc.nextInt();
            for (int i = 0; i < n2; i++) {
                int tmp = sc.nextInt();
                if (set.contains(tmp)) {
                    System.out.print(tmp + " ");
                }
            }
            System.out.println();
        }
    }
}
