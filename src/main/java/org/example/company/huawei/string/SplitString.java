package org.example.company.huawei.string;

import java.util.*;

public class SplitString {
    /*
        HJ104 按长度为8拆分每个字符串后输出到新的字符串数组，
              长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                String str = sc.next();
                str = str + "00000000";
                while (str.length() > 8) {
                    System.out.println(str.substring(0, 8));
                    str = str.substring(8);
                }
            }
        }
    }
}
