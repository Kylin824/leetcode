package org.example.offer.stack;

import java.util.Stack;

public class MinElementInStack {
    /*
        NO.20
        定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
        注意：保证测试中不会当栈为空的时候，对栈调用pop()或者min()或者top()方法。
     */
    /*
        思路:
            1. 辅助栈
            2. 压缩还原
     */
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        stack.push(node);
        if (minStack.empty()) {
            minStack.push(node);
        }
        else {
            if (node <= minStack.peek()) {
                minStack.push(node);
            }
            else {
                minStack.push(minStack.peek());
            }
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }



    int min = Integer.MAX_VALUE;

    public void push1(int node) {
        // 栈空时
        if (stack.empty()) {
            stack.push(node);
            min = node;
        }
        // 不直接存数，而是存与最小值的差值
        stack.push(node - min);
        if (node < min) {
            min = node;
        }
    }

    public void pop1(int node) {
        if (!stack.empty()) {
            if (stack.peek() < 0)
                // 更新最小值
                min = min - stack.peek();
            stack.pop();
        }
    }

    public int top1() {
        return stack.peek();
    }

    public int min1() {
        return min;
    }

    public static void main(String[] args) {
        // ["PSH3","MIN","PSH4","MIN","PSH2","MIN","PSH3","MIN","POP","MIN","POP","MIN","POP","MIN","PSH0","MIN"]
        MinElementInStack ms = new MinElementInStack();
        ms.push(3);
        System.out.println(ms.min());
        ms.push(4);
        System.out.println(ms.min());
        ms.push(2);
        System.out.println(ms.min());
    }
}
