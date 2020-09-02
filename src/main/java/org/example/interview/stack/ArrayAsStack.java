package org.example.interview.stack;

public class ArrayAsStack {
    /*
    面试题 03.01. 三合一
    用一个数组来实现三个栈。
    stackNum代表选中的栈(0,1,2) value是插入的值
     */

    int[] arr;
    int[] indices;
    int stackSize;

    public ArrayAsStack(int stackSize) {
        arr = new int[3 * stackSize];
        indices = new int[]{0, 1, 2};
        this.stackSize = stackSize;
    }

    public void push(int stackNum, int value) {
        if (indices[stackNum] >= stackSize * 3) {
            return;
        }
        arr[indices[stackNum]] = value;
        indices[stackNum] += 3;
    }

    public int pop(int stackNum) {
        if (isEmpty(stackNum)) {
            return -1;
        }
        indices[stackNum] -= 3;
        return arr[indices[stackNum]];
    }

    public int peek(int stackNum) {
        if (isEmpty(stackNum)) {
            return -1;
        }
        return arr[indices[stackNum] - 3];
    }

    public boolean isEmpty(int stackNum) {
        return indices[stackNum] < 3;
    }

    public static void main(String[] args) {
        ArrayAsStack as = new ArrayAsStack(1);
        as.push(0, 1);
        as.push(0, 2);
        System.out.println(as.pop(0));
        System.out.println(as.pop(0));
        System.out.println(as.pop(0));
        System.out.println(as.isEmpty(0));
    }
}
