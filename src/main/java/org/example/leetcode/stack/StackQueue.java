package org.example.leetcode.stack;

import java.util.Stack;

public class StackQueue {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public StackQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        while (stack1.size() > 1) {
            stack2.push(stack1.pop());
        }
        if (stack1.size() == 1) {
            int head = stack1.pop();
            while (stack2.size() > 0) {
                stack1.push(stack2.pop());
            }
            return head;
        }
        else {
            return -1;
        }
    }
}
