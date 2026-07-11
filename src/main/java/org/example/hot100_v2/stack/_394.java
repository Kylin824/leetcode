package org.example.hot100_v2.stack;

import java.util.Stack;

/**
 * @author kylin
 * @date 2026/7/11
 */

public class _394 {

    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ']') {
                stack.push(c);
            } else {
                // 遇到']'就出栈直到'['
                StringBuilder subStr = new StringBuilder();
                while (!stack.isEmpty() && stack.peek() != '[') {
                    subStr.append(stack.pop());
                }
                stack.pop(); // 弹出'['
                StringBuilder numStr = new StringBuilder();
                while (!stack.isEmpty() && stack.peek() >= '0' && stack.peek() <= '9') {
                    numStr.append(stack.pop());
                }
                int num = Integer.parseInt(numStr.reverse().toString());
                for (int j = 1; j <= num; j++) {
                    for (int l = subStr.length() - 1; l >= 0; l--) {
                        stack.push(subStr.charAt(l));
                    }
                }
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        _394 a = new _394();
        System.out.println(a.decodeString("3[a]2[bc]"));
    }
}
