package org.example.company.duxiaoman;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String colors = sc.nextLine();
            String pic = sc.nextLine();
            char[] map = new char[26];
            for (char ch : colors.toCharArray()) {
                map[ch - 'A']++;
            }
            int count = 0;
            for (char ch : pic.toCharArray()) {
                if (map[ch - 'A'] > 0) {
                    count++;
                    map[ch - 'A']--;
                }
            }
            System.out.println(count);
        }
    }
}
