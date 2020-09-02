package org.example.interview.stack;

import java.util.Stack;

public class MinStack {
    /*
    面试题 03.02. 栈的最小值
     */
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
        }
        else if (x < minStack.peek()) {
            minStack.push(x);
        }
        else {
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
