package org.example.company.meituan;

import java.util.Scanner;
import java.util.Stack;

public class AndOr {
    /*
    输入true or false and false or true and false    计算结果

    and优先级高于or

    思路：
    操作数栈和操作符栈

    操作数直接入栈

    操作符：
    and 直接入栈

    or {栈顶为and 出栈并计算值}
       {栈顶为or 直接入栈}
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str = in.nextLine();
            String[] words = str.split(" ");
            Stack<Boolean> stack1 = new Stack<Boolean>();
            Stack<String> stack2 = new Stack<String>();
            int flag = 0;
            int err = 0;
            for (String s : words) {
                if (s.equals("true") && flag == 0) {
                    stack1.push(true);
                    flag = 1;
                } else if (s.equals("false") && flag == 0) {
                    stack1.push(false);
                    flag = 1;
                } else if (s.equals("and") && flag == 1) {
                    flag = 0;
                    stack2.push("and");
//                    if (!stack2.isEmpty() && stack2.peek().equals("and") && stack1.size() >= 2) {
//                        boolean b1 = stack1.pop();
//                        boolean b2 = stack1.pop();
//                        boolean tmp = b1 && b2;
//                        stack1.push(tmp);
//                    } else {
//                        stack2.push("and");
//                    }
                } else if (s.equals("or") && flag == 1) {
                    flag = 0;
                    if (!stack2.isEmpty() && stack2.peek().equals("and") && stack1.size() >= 2) {
                        boolean b1 = stack1.pop();
                        boolean b2 = stack1.pop();
                        boolean tmp = b1 && b2;
                        stack1.push(tmp);
                        stack2.pop();
                        stack2.push("or");
                    } else {
                        stack2.push("or");
                    }
                } else if (((s.equals("or") || s.equals("and")) && flag == 0) || ((s.equals("true") || s.equals("false")) && flag == 1)) {
                    err = 1;
                    break;
                }
            }
            if (err == 0) {
                boolean res = true;
                while (!stack1.isEmpty() && !stack2.isEmpty()) {
                    String op = stack2.pop();
                    Boolean b1 = stack1.pop();
                    Boolean b2 = stack1.pop();
                    if (op.equals("and")) {
                        if (stack2.isEmpty()) {
                            res = b1 && b2;
                        } else {
                            stack1.push(b1 && b2);
                        }
                    }
                    else if (op.equals("or")) {
                        if (stack2.isEmpty()) {
                            res = b1 || b2;
                        } else {
                            stack1.push(b1 || b2);
                        }
                    }
                }
                System.out.println(res);
            }
            else {
                System.out.println("error");
            }

        }
    }
}
