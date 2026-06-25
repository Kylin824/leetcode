package org.example.hot100_v2;

import java.util.Stack;

/**
 * 有效括号：
 * @author kylin
 * @date 2026/6/25
 */
public class _20 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char lc = stack.pop();
                if ((c == ')' && lc != '(') || (c == ']' && lc != '[') || (c == '}' && lc != '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty(); // '['
    }
}
