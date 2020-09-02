package org.example.interview.stack;

import java.util.Stack;

public class TwoStackAsQueue {
    /*
    面试题 03.04. 化栈为队
    实现一个MyQueue类，该类用两个栈来实现一个队列。
     */

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    /** Initialize your data structure here. */
    public TwoStackAsQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        int val = stack2.pop();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return val;
    }

    /** Get the front element. */
    public int peek() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        int val = stack2.peek();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return val;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty();
    }
}
