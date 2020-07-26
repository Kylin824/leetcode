package org.example.company.huawei.string;

import java.util.*;

public class ReverseString {
    /*
        HJ106 输入“I am a student”，输出“tneduts a ma I”。
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine(); // next()遇到空格结束 nextLine()遇到回车结束
            StringBuilder sb = new StringBuilder(str);
            System.out.println(sb.reverse());
        }
    }
}
