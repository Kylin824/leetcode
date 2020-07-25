package org.example.company.huawei.dp;

import java.util.*;

public class Choir {
    /*
        HJ24 计算最少出列多少位同学，使得剩下的同学排成合唱队形
     */
    /*
        思路
        计算每个人左边最多能站几个人dp_left[]  == 最长上升子序列
        计算每个人右边最多能站几个人dp_right[] ==  最长下降子序列
        两个dp数组相加就得到以每个人为中间两边所能站的最多人数
        ∴ 出列数 = 总人数 - 最多人数
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int[] dp_left = new int[n];
            int[] dp_right = new int[n];

            dp_left[0] = 1;
            for (int i = 1; i < n; i++) {
                dp_left[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (arr[i] > arr[j]) {
                        dp_left[i] = Math.max(dp_left[i], dp_left[j] + 1);
                    }
                }
            }

            dp_right[n - 1] = 1;
            for (int i = n - 2; i >= 1; i--) {
                dp_right[i] = 1;
                for (int j = n - 1; j > i; j--) {
                    if (arr[j] < arr[i]) {
                        dp_right[i] = Math.max(dp_right[i], dp_right[j] + 1);
                    }
                }
            }

            int max = 0;
            for (int i = 0; i < n; i++) {
                if (max < dp_left[i] + dp_right[i] - 1)
                    max = dp_left[i] + dp_right[i] - 1;
            }

            System.out.println(n - max);
        }
    }
}
