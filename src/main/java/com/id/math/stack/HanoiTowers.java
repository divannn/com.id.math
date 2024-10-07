package com.id.math.stack;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HanoiTowers {

    public static <T> void move(int n, Rod<T> source, Rod<T> middle, Rod<T> target) {
        if (n == 0) {
            return;
        }
        move(n - 1, source, target, middle);
        if (!source.isEmpty()) {
            System.err.printf("Move plate %d from rod '%s' to rod '%s' \n", n, source.getName(), target.getName());
            target.push(source.pop());
        }
        move(n - 1, middle, source, target);
    }

    @Test
    public void test() {
        Rod<Integer> source = new Rod<>("SOURCE");
        source.push(4);
        source.push(3);
        source.push(2);
        source.push(1);
        Rod<Integer> target = new Rod<>("TARGET");
        Rod<Integer> middle = new Rod<>("MIDDLE");
        move(source.size(), source, middle, target);

        assertEquals(target.size(), 4);
        assertEquals(target.peek(), new Integer(1));
    }

    private static class Rod<T> extends Stack<T> {
        String name;

        public Rod(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
