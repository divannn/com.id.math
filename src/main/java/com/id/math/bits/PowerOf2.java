package com.id.math.bits;


import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

//leetcode
public class PowerOf2 {

    public static boolean isPowerOf2(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("Invalid arg");
        }
        return (value & value - 1) == 0;
    }

    @Test
    public void test() {
        assertTrue(isPowerOf2(1));
        assertTrue(isPowerOf2(2));
        assertTrue(isPowerOf2(8));
        assertTrue(isPowerOf2(1024));
        assertFalse(isPowerOf2(3));
        assertFalse(isPowerOf2(62));
    }
}
