package com.id.math.numbers;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberOfDigits {

    /**
     * Calculates number of digit positions of integer using base 10.
     * Example:
     * 5 - 1
     * 301 - 3
     */
    public static int numberOdDigits(int value) {
        if (value == 0) {
            return 1;
        }
        int n = value;
        int result = 0;
        while (n != 0) {
            result++;
            n /= 10;
        }
        return result;
    }

    @Test
    public void test() {
        assertEquals(1, numberOdDigits(0));
        assertEquals(1, numberOdDigits(-1));
        assertEquals(3, numberOdDigits(893));
        assertEquals(4, numberOdDigits(-1234));
    }

}
