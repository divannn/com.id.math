package com.id.math.numbers;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * BTW, in java % takes sign of first arg:
 * 8%3=2
 * 8%-3=2
 * -8%-3=-2
 * -8%-3=-2
 */
public class Reminder {

    /** Find reminder given the number (dividend) and a divisor.
     */
    public int getReminder(int n, int divisor) {
        if (divisor <= 0) {
            return -1;
        }
        int quotient = n / divisor;
        return n - quotient * divisor;
    }

    @Test
    public void test() {
        assertEquals(-1, getReminder(2, 0));
        assertEquals(0, getReminder(0, 1));
        assertEquals(0, getReminder(0, 3));
        assertEquals(1, getReminder(1, 2));
        assertEquals(0, getReminder(4, 4));
        assertEquals(0, getReminder(21, 7));
        assertEquals(2, getReminder(26, 4));
        assertEquals(0, getReminder(121, 11));
    }

/*    private void testJavaReminder() {
        System.err.println(8 % 3);
        System.err.println(8 % -3);
        System.err.println(-8 % 3);
        System.err.println(-8 % -3);
    }*/
}
