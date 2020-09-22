package org.example.company.hm;

import akka.stream.impl.fusing.Scan;

import java.util.Scanner;

public class One {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = sc.nextLine();
        String num2 = sc.nextLine();
        int len = Math.min(num1.length(), num2.length());
        StringBuilder res = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < len; i++) {
            int a = num1.charAt(num1.length() - 1 - i) - '0';
            int b = num2.charAt(num2.length() - 1 - i) - '0';
            int sum = a + b;
            if (carry == 0 && sum <= 9) {
                res.append(sum);
                carry = 0;
            }
            else if (carry == 0 && sum >= 9) {
                res.append(sum % 10);
                carry = 1;
            }
            else if (carry == 1 && sum + 1 <= 9) {
                res.append(sum);
                carry = 0;
            }
            else if (carry == 1 && sum + 1 >= 9) {
                res.append((sum + 1) % 10);
                carry = 1;
            }
        }
        if (num1.length() < num2.length()) {
            for (int i = len; i < num2.length(); i++) {
                int sum = num2.charAt(i) - '0';
                if (carry == 0 && sum <= 9) {
                    res.append(sum);
                    carry = 0;
                }
                else if (carry == 0 && sum >= 9) {
                    res.append(sum % 10);
                    carry = 1;
                }
                else if (carry == 1 && sum + 1 <= 9) {
                    res.append(sum);
                    carry = 0;
                }
                else if (carry == 1 && sum + 1 >= 9) {
                    res.append((sum + 1) % 10);
                    carry = 1;
                }
            }
        }
        else if(num1.length() > num2.length()){
            for (int i = len; i < num1.length(); i++) {
                int sum = num1.charAt(i) - '0';
                if (carry == 0 && sum <= 9) {
                    res.append(sum);
                    carry = 0;
                }
                else if (carry == 0 && sum >= 9) {
                    res.append(sum % 10);
                    carry = 1;
                }
                else if (carry == 1 && sum + 1 <= 9) {
                    res.append(sum);
                    carry = 0;
                }
                else if (carry == 1 && sum + 1 >= 9) {
                    res.append((sum + 1) % 10);
                    carry = 1;
                }
            }
        }
        if (carry == 1) {
            res.append(carry);
        }
        System.out.println(res.reverse().toString());
    }
}
