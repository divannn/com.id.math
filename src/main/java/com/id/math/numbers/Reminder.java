package com.id.math.numbers;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Reminder {


    public int getReminder(int n, int divisor) {
        if (divisor <= 0) {
            return -1;
        }
        int whole = n / divisor;
        return n - whole * divisor;
    }

    @Test
    public void test1() {
        assertEquals(-1, getReminder(2, 0));
        assertEquals(0, getReminder(0, 1));
        assertEquals(0, getReminder(0, 3));
        assertEquals(1, getReminder(1, 2));
        assertEquals(0, getReminder(4, 4));
        assertEquals(0, getReminder(21, 7));
        assertEquals(2, getReminder(26, 4));
        assertEquals(0, getReminder(121, 11));
    }
}
