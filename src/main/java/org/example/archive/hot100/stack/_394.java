package org.example.archive.hot100.stack;


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

        System.out.println(decodeString("3[a]2[bc]")); // aaabcbc
        System.out.println(decodeString("3[a2[bc]]")); // abcbcabcbcabcbc
        System.out.println(decodeString("100[leetcode]")); // abcbcabcbcabcbc


    }

    public static String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c != ']') {
                stack.push(c);
            } else {
                // 子串
                StringBuilder sb = new StringBuilder();
                while (stack.peek() != '[') {
                    sb.append(stack.pop());
                }
                sb = sb.reverse();
                stack.pop(); // '['

                StringBuilder nb = new StringBuilder();
                // 数值
                while (!stack.isEmpty() && stack.peek() >= '0' && stack.peek() <= '9') {
                    nb.append(stack.pop());
                }
                nb = nb.reverse();
                int num = Integer.parseInt(nb.toString());
                for (int i = 1; i <= num; i++) {
                    for (int j = 0; j < sb.length(); j++) {
                        stack.push(sb.charAt(j));
                    }
                }
            }
        }
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        return res.reverse().toString();
    }


}
