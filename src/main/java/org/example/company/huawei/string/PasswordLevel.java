package org.example.company.huawei.string;

import java.util.Scanner;

public class PasswordLevel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();

            int score = 0;

            // 长度
            if (str.length() >= 8)
                score += 25;
            else if (5 <= str.length() && str.length() <= 7)
                score += 10;
            else
                score += 5;

            // 字母
            boolean lowerCase = false;
            boolean upperCase = false;
            // 数字
            int num = 0;
            // 符号
            int symbol = 0;

            for (int i = 0; i < str.length(); i++) {
                if (Character.isLowerCase(str.charAt(i)) && !lowerCase) {
                    score += 10;
                    lowerCase = true;
                }
                if (Character.isUpperCase(str.charAt(i)) && !upperCase) {
                    score += 10;
                    upperCase = true;
                }
                if (num == 0 && Character.isDigit(str.charAt(i))) {
                    score += 10;
                    num++;
                }
                if (num == 1 && Character.isDigit(str.charAt(i))) {
                    score += 10;
                    num++;
                }
                if (symbol == 0 && (str.charAt(i) < '0' || (str.charAt(i) > '9' && str.charAt(i) < 'A')
                        || (str.charAt(i) > 'Z' && str.charAt(i) < 'a') || str.charAt(i) > 'z')) {
                    score += 10;
                    symbol++;
                }
                if (symbol == 1 && (str.charAt(i) < '0' || (str.charAt(i) > '9' && str.charAt(i) < 'A')
                        || (str.charAt(i) > 'Z' && str.charAt(i) < 'a') || str.charAt(i) > 'z')) {
                    score += 15;
                    symbol++;
                }
            }

            // 奖励
            // 2 分: 字母和数字
            // 3 分: 字母、数字和符号
            // 5 分: 大小写字母、数字和符号
            if (upperCase && lowerCase && num > 0 && symbol > 0)
                score += 5;
            else if (upperCase || lowerCase && num > 0 && symbol > 0)
                score += 3;
            else if (upperCase || lowerCase && num > 0)
                score += 2;

            System.out.println("up: " + upperCase + " low: " + lowerCase + " num : " + num + " sym: " + symbol);

            if (score >= 90)
                System.out.println("VERY_SECURE");
            else if (score >= 80)
                System.out.println("SECURE");
            else if (score >= 70)
                System.out.println("VERY_STRONG");
            else if (score >= 60)
                System.out.println("STRONG");
            else if (score >= 50)
                System.out.println("AVERAGE");
            else if (score >= 40)
                System.out.println("WEAK");
            else if (score >= 30)
                System.out.println("VERY_WEAK");
        }
    }
}
