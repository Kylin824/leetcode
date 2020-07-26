package org.example.company.huawei.search;

import java.util.Arrays;
import java.util.Scanner;

public class TwentyFourGame {
    /*
    HJ 67 给出4个1-10的数字，通过加减乘除，得到数字为24就算胜利
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int[] arr = new int[4];
            for (int i = 0; i < 4; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println(dfs(arr, 24));
        }
    }
    public static boolean dfs(int[] arr, int target) {
        if (arr.length == 1) {
            if (arr[0] == target) {
                return true;
            }
            else
                return false;
        }
        int[] newArr = Arrays.copyOfRange(arr, 1, arr.length);
        boolean plus = dfs(newArr, target - arr[0]);
        boolean subs = dfs(newArr, target + arr[0]);
        boolean div = dfs(newArr, target * arr[0]);
        boolean mult = (target % arr[0] == 0 && dfs(newArr, target / arr[0]));
        return plus || subs || div || mult;
    }
}
