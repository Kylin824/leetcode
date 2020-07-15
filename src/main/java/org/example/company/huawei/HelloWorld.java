package org.example.company.huawei;

import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            char[] chars = str.toCharArray();
            int eng = 0;
            int space = 0;
            int num = 0;
            int other = 0;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] >= '0' && chars[i] <= '9') num++;
                else if(chars[i] >= 'a' && chars[i] <= 'z') eng++;
                else if(chars[i] >= 'A' && chars[i] <= 'Z') eng++;
                else if(chars[i] == ' ') space++;
                else other++;
            }
            System.out.println(eng);
            System.out.println(space);
            System.out.println(num);
            System.out.println(other);
        }
    }

}
