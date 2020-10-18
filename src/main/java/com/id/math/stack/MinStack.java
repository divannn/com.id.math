package com.id.math.stack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * <p>
 * push(x) -- Push element x onto stack.
 * <p>
 * pop() -- Removes the element on top of the stack.
 * <p>
 * top() -- Get the top element.
 * <p>
 * getMin() -- Retrieve the minimum element in the stack.
 * <p>
 * @leetcode https://leetcode.com/problems/min-stack/
 */
public class MinStack {

    private static final int MAX_SIZE = 1000;
    private int size;
    private Node[] data;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        data = new Node[MAX_SIZE];
        size = -1;
    }

    public boolean isEmpty() {
        return size == -1;
    }
    public boolean isFull() {
        return size == MAX_SIZE - 1;
    }

    public void push(int x) {
        if (isFull()) {
            throw new IllegalStateException("Stack is full");
        }
        Node node;
        if (isEmpty()) {
            node = new Node(x, x);
        } else {
            if (x < getMin()) {
                node = new Node(x, x);
            } else {
                node = new Node(x, getMin());
            }
        }
        data[++size] = node;
    }

    public void pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        data[size--] = null;
    }

    public int top() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return data[size].value;
    }

    public int getMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return data[size].minValue;
    }

    private static class Node {
        int value;
        int minValue;//MEA - keep current min value in each node.

        private Node(int value, int minValue) {
            this.value = value;
            this.minValue = minValue;
        }
    }

    @Test
    public void test() {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        assertEquals(-3, minStack.getMin());
        minStack.pop();
        assertEquals(0, minStack.top());
        assertEquals(-2, minStack.getMin());
    }
}



