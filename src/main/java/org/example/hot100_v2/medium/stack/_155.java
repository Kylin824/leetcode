package org.example.hot100_v2.medium.stack;

import java.util.Stack;

/**
 * @author kylin
 * @date 2026/7/15
 */
public class _155 {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public _155() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int value) {
        stack.push(value);
        if (minStack.isEmpty()) {
            minStack.push(value);
        } else {
            minStack.push(Math.min(minStack.peek(), value));
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
