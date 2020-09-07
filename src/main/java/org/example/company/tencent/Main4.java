package org.example.company.tencent;

import java.util.*;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int n = sc.nextInt();
            int[] arr = new int[n];
            int[] sort = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                sort[i] = arr[i];
            }
            Arrays.sort(sort);
            int lMid = sort[n / 2 - 1];
            int rMid = sort[n / 2];
            for (int i = 0; i < n; i++) {
                if (arr[i] > lMid) {
                    System.out.println(lMid);
                }
                else {
                    System.out.println(rMid);
                }
            }
        }
    }
}
