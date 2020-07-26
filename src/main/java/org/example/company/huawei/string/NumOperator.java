package org.example.company.huawei.string;

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
        1. 检查合法性（处理负数）
        2. 中缀表达式转为后缀表达式  1+2*3+(4*5+6)*7 -> 123*+45*6+7*+
        3. 计算后缀表达式
     */
    /*
    中缀转后缀
        1.遇到操作数，直接输出；
        2.遇到左括号或栈为空，入栈；
        4.遇到右括号，一直出栈并将出栈的元素输出，直到弹出栈的是左括号，左括号不输出；
        5.遇到其他运算符’+”-”*”/’时，弹出所有优先级大于或等于该运算符的栈顶元素，然后将该运算符入栈；
        6.最终将栈中的元素依次出栈，输出。
        经过上面的步骤，得到的输出既是转换得到的后缀表达式。
        举例：1+2*3+(4*5+6)*7 -> 123*+45*6+7*+
     */
    /*
        后缀计算
        利用栈
        从左到右遍历表达式的每个数字和符号，
        遇到是数字就进栈，
        遇到是符号，就将处于栈顶两个数字出栈，进行运算，
        运算结果进栈，一直到最终获得结果。
     */
    /*
    处理负数
        '-'号前面是')'或者数字时，'-'代表减号
        其他情况则代表负号，将'-'号后面的数 x 包起来变成 (0-x)
     */
    /*
    处理大于0的情况
        添加数字结束符号'#'
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            String newStr = preProcessStr(str);
            System.out.println(newStr);
            String postStr = midToPost(newStr);
            System.out.println(postStr);
            System.out.println(postCalculate(postStr));
        }
    }

    public static String preProcessStr(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '-') {
                if (Character.isDigit(str.charAt(i - 1))) {
                    sb.append(str.charAt(i));
                } else if (str.charAt(i - 1) == ')') {
                    sb.append(str.charAt(i));
                } else {
                    sb.append('(').append("0-");
                    i++;
                    while (Character.isDigit(str.charAt(i))) {
                        sb.append(str.charAt(i));
                        i++;
                    }
                    sb.append(')');
                    sb.append(str.charAt(i));
                }
            } else {
                if (str.charAt(i) == '[' || str.charAt(i) == '{'){
                    sb.append('(');
                }
                else if (str.charAt(i) == ']' || str.charAt(i) == '}'){
                    sb.append(')');
                }
                else
                    sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static String midToPost(String input) {
        Stack<Character> op_stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                sb.append(input.charAt(i));
                while (i + 1 < input.length() && Character.isDigit(input.charAt(i + 1))) {
                    i++;
                    sb.append(input.charAt(i));
                }
                sb.append('#'); // 数字结束标志
            } else if (op_stack.isEmpty() || input.charAt(i) == '(') {
                op_stack.push(input.charAt(i));
            } else if (input.charAt(i) == ')') {
                while (op_stack.peek() != '(') {
                    sb.append(op_stack.pop());
                }
                op_stack.pop();
            } else if (isPriority(input.charAt(i), op_stack.peek())) {
                // 优先级高于栈顶运算符，入栈
                op_stack.push(input.charAt(i));
            } else {
                // 优先级低于等于栈顶运算符则将栈顶运算符弹出并输出
                while (!op_stack.isEmpty() && op_stack.peek() != '(' && !isPriority(input.charAt(i), op_stack.peek())) {
                    sb.append(op_stack.pop());
                }
                op_stack.push(input.charAt(i));
            }
        }
        while (!op_stack.isEmpty())
            sb.append(op_stack.pop());
        return sb.toString();
    }

    public static boolean isPriority(char cur, char peek) {
        if (peek == '(') {
            return true;
        } else if ((cur == '+' || cur == '-') && (peek == '*' || peek == '/')) {
            return false;
        } else if ((cur == '+' || cur == '-') && (peek == '+' || peek == '-')) {
            return false;
        } else if ((cur == '*' || cur == '/') && (peek == '+' || peek == '-')) {
            return true;
        } else if ((cur == '*' || cur == '/') && (peek == '*' || peek == '/')) {
            return false;
        }
        return false;
    }

    public static int postCalculate(String str) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                // 是数字就进栈
                int begin = i, end = i;
                while (str.charAt(i) != '#') {
                    i++;
                    end++;
                }
                stack.push(Integer.valueOf(str.substring(begin, end)));
            } else {
                // 是运算符就取出栈顶两个元素计算结果，计算结果入栈
                int b = stack.pop();
                int a = stack.pop();
                if (str.charAt(i) == '+')
                    stack.push(a + b);
                else if (str.charAt(i) == '-')
                    stack.push(a - b);
                else if (str.charAt(i) == '*')
                    stack.push(a * b);
                else if (str.charAt(i) == '/')
                    stack.push(a / b);
            }
        }
        return stack.pop();
    }
}
