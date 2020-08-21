package org.example.leetcode.stack;

import scala.Int;

import java.util.Stack;

public class MinStack {
    /*
    155. 最小栈
        设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。

        push(x) —— 将元素 x 推入栈中。
        pop() —— 删除栈顶的元素。
        top() —— 获取栈顶元素。
        getMin() —— 检索栈中的最小元素。
     */

    Stack<Integer> minStack;
    Stack<Integer> extStack;


    public MinStack() {
        minStack = new Stack<>();
        extStack = new Stack<>();
    }

    public void push(int x) {
        minStack.push(x);
        if (extStack.isEmpty()) {
            extStack.push(x);
        }
        else {
            if (x < extStack.peek()) {
                extStack.push(x);
            }
            else {
                extStack.push(extStack.peek()); // 最小值再次入栈
            }
        }
    }

    public void pop() {
        minStack.pop();
        extStack.pop();
    }

    public int top() {
        return minStack.peek();
    }

    public int getMin() {
        return extStack.peek();
    }

    public static void main(String[] args) {
        MinStack ms = new MinStack();
        ms.push(1);
        ms.push(2);
        ms.push(3);
        System.out.println(ms.getMin());

    }
}
