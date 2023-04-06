package org.example.offer.bst.structure.stack;

import java.util.Stack;

/**
 *
 */
public class MinStack {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MinStack() {
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }

    /**
     * 入栈
     * 如果比最小值小，则同时入最小栈
     * @param newNum
     */
    public void push(int newNum) {
        if (this.stackMin.isEmpty()) {
            this.stackMin.push(newNum);
        } else if (newNum <= this.getMin()) {
            this.stackMin.push(newNum);
        }
        this.stackData.push(newNum);
    }

    /**
     * 出栈
     * 如果是最小值，则同时出最小栈
     * @return
     */
    public int pop() {
        if (this.stackData.isEmpty()) {
            throw new RuntimeException("Pop failed: Stack is empty");
        }
        int value = this.stackData.pop();
        if (value == this.getMin()) {
            this.stackMin.pop();
        }
        return value;
    }

    /**
     * 获取最小栈的栈顶值
     * @return
     */
    public int getMin() {
        if (this.stackMin.isEmpty()) {
            throw new RuntimeException("Get min failed: Stack is empty");
        }
        return this.stackMin.peek();
    }

    public static void main(String[] args) {
        MinStack ms = new MinStack();
        ms.push(4);
        ms.push(3);
        ms.push(2);
        ms.push(5);
        ms.push(8);
        ms.push(2);
        System.out.println(ms.stackMin.peek());
    }
}
