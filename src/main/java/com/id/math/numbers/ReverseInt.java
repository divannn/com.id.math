package com.id.math.numbers;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseInt {

    /**
     * Reverse int in terms of decimals.
     * Don't care about overflows.
     * Example:
     * 1234 -> 4321
     * 1 -> 1
     */
    public static int reverse(int num) {
        int rev = 0;
        while (num != 0) {
            rev = rev * 10 + num % 10;
            num /= 10;
        }
        return rev;
    }

    @Test
    public void test() {
        assertEquals(0, reverse(0));
        assertEquals(1, reverse(1));
        assertEquals(123, reverse(321));
        assertEquals(-123, reverse(-321));
        assertEquals(9870789, reverse(9870789));
    }

}
