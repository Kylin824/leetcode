package org.example.company.huawei.string;

import java.util.Scanner;

public class DateToDays {
    /*
        计算日期是当年第几天
     */
    /*
    四年一闰;百年不闰, 四百年再闰
    平年365天 闰年366天
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int year = sc.nextInt();
            int month = sc.nextInt();
            int day = sc.nextInt();
            int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            int ret = 0;
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                months[1] = 29;
            }
            for (int i = 0; i < month - 1; i++) {
                ret += months[i];
            }
            ret += day;
            System.out.println(ret);
        }

    }
}
