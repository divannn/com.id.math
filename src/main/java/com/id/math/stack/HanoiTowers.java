package com.id.math.stack;

import org.junit.Test;

import java.util.Stack;

public class HanoiTowers {

    public static <T> void move(int n, Stack<T> source, Stack<T> middle, Stack<T> target) {
        if (n == 0) {
            return;
        }
        move(n - 1, source, target, middle);
        if (!source.isEmpty()) {
            System.err.printf("PLate %d from rod  to rod {}\n", n);
            target.push(source.pop());
        }
        move(n - 1, middle, source, target);
    }

    @Test
    public void test() {
        Stack<Integer> source = new Stack<>();
        source.push(4);
        source.push(3);
        source.push(2);
        source.push(1);
        Stack<Integer> target = new Stack<>();
        Stack<Integer> middle = new Stack<>();
        move(source.size(), source, middle, target);
        System.err.println("target rod: " + target.size());
        System.err.println("target top plate: " + target.peek());
    }
}
