package com.id.math.numbers;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class FindMaxWithoutComparison {

    /**
     * Find max among of two without using comparison operations.
     */
    public static int max(int a, int b) {
        int diff = a - b;//overflow may occur here - disregard.
        int sign = diff >>> 31;
        return a - sign * diff;
    }

    @Test
    public void test() {
        assertEquals(5, max(2, 5));
        assertEquals(4, max(0, 4));
        assertEquals(3, max(3, 1));
        assertEquals(2, max(2, 2));
        assertEquals(0, max(0, 0));

        assertEquals(-2, max(-2, -2));
        assertEquals(3, max(3, -1));
        assertEquals(1, max(-3, 1));
        assertEquals(-8, max(-8, -10));
    }

}
