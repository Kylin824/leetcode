package org.example.company.xiaomi;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.nextLine();
            System.out.println(removeDuplicate(input));
        }
    }

    public static String removeDuplicate(String str) {
        char[] chars = new char[256];
        StringBuilder sb = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (chars[ch] == 0) {
                chars[ch]++;
                sb.append(ch);
            }
            else
                continue;
        }
        return sb.toString();
    }
}
