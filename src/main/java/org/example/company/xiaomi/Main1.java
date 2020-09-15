package org.example.company.xiaomi;

import java.util.Scanner;
import java.util.Stack;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.next();
            System.out.println(isValid(input));
        }
    }

    public static boolean isValid(String str) {
        if (str.equals("")) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        if (str.length() == 0)
            return true;
        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }
            else if (stack.empty()) {
                return false;
            }
            else if ((ch == ')' && stack.peek() == '(') || (ch == ']' && stack.peek() == '[') || (ch == '}' && stack.peek() == '{')) {
                stack.pop();
            }
            else {
                return false;
            }
        }
        return stack.empty();
    }

    public static boolean isValid1(String str) {
        if (str.length() == 0)
            return true;
        if (str.length() % 2 != 0)
            return false;
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (ch == '(') {
                stack.push(')');
            }
            else if (ch == '{') {
                stack.push('}');
            }
            else if (ch == '[') {
                stack.push(']');
            }
            else if (stack.isEmpty() || stack.peek() != ch){
                return false;
            }
            else
                stack.pop();
        }
        return stack.empty();
    }
}
