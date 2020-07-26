package org.example.company.huawei.string;

import java.security.interfaces.ECKey;
import java.util.Scanner;
import java.util.Stack;

public class NumOperator {
    /*
        HJ54
        给定一个字符串描述的算术表达式，计算出结果值。
        输入字符串长度不超过100，合法的字符包括”+, -, *, /, (, )”，”0-9”，
        字符串内容的合法性及表达式语法的合法性由做题者检查。本题目只涉及整型计算。
     */
    /*
        思路
        1. 检查合法性
        2. 中缀表达式转为后缀表达式
        3. 计算后缀表达式
     */
    /*
    中缀转后缀
        1.遇到操作数，直接输出；
        2.栈为空时或遇到左括号，入栈；
        4.遇到右括号，执行出栈操作，并将出栈的元素输出，直到弹出栈的是左括号，左括号不输出；
        5.遇到其他运算符’+”-”*”/’时，弹出所有优先级大于或等于该运算符的栈顶元素，然后将该运算符入栈；
        6.最终将栈中的元素依次出栈，输出。
        经过上面的步骤，得到的输出既是转换得到的后缀表达式。
        举例：a+b*c+(d*e+f)g ———> abc+de*f+g*+
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            Stack<Character> stack = new Stack<>();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                if (Character.isDigit(str.charAt(i))) {
                    sb.append(str.charAt(i));
                }
                else if (stack.isEmpty() || str.charAt(i) == '(') {
                    stack.push(str.charAt(i));
                }
                else if (str.charAt(i) == ')') {
                    while (stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    sb.append(stack.pop());
                }
            }

        }
    }
}
