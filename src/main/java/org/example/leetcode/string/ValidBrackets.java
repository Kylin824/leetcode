package org.example.leetcode.string;

import java.util.Stack;

public class ValidBrackets {
    /*
    20. 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效

    示例 1:
    输入: "()"
    输出: true

    示例 2:
    输入: "()[]{}"
    输出: true

    示例 3:
    输入: "(]"
    输出: false

     */

    // quick solution
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if (s.length() == 0)
            return true;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
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

    public static void main(String[] args) {
        System.out.println(isValid("]"));
    }
}
