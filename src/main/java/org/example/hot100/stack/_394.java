package org.example.hot100.stack;


/*
给定一个经过编码的字符串，返回它解码后的字符串。

编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。
注意 k 保证为正整数。

你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。

此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，
例如不会出现像 3a 或 2[4] 的输入。
 */

import java.util.Stack;

public class _394 {

    public static void main(String[] args) {

//        System.out.println(decodeString("3[a]2[bc]")); // aaabcbc
        System.out.println(decodeString("3[a2[c]]")); // accaccacc


    }

    public static String decodeString(String s) {

        StringBuilder sb = new StringBuilder();
        StringBuilder res = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c != ']') {
                stack.push(c);
            } else {
                while (stack.peek() != '[') {
                    sb.append(stack.pop());
                }
                sb = sb.reverse();
                stack.pop();
                sb.append(res);
                if (stack.peek() >= '0' && stack.peek() <= '9') {
                    int num = stack.pop() - '0';
                    for (int i = 1; i <= num; i++) {
                        res.append(sb);
                    }
                }
                sb = new StringBuilder();
            }
        }
        return res.toString();
    }


}
