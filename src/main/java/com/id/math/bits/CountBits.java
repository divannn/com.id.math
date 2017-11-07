package com.id.math.bits;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountBits {


    @Test
    public void test1() {
        assertEquals(0, countToggledBits1(0));
        assertEquals(1, countToggledBits1(8));
        int v = 0xFF;
        int actual = countToggledBits1(v);
        assertEquals(8, actual);
        System.err.println(Integer.toBinaryString(v) + " -> " + actual);

        assertEquals(32, countToggledBits1(-1));
    }

    @Test
    public void test2() {
        assertEquals(0, countToggledBits2(0));
        assertEquals(1, countToggledBits2(8));
        int v = 0xFF;
        int actual = countToggledBits2(v);
        assertEquals(8, actual);
        System.err.println(Integer.toBinaryString(v) + " -> " + actual);

        assertEquals(32, countToggledBits2(-1));
    }

    /**
     * Naive - shift bits to the right on by one.
     * O(log2 N) = O(number of digits)
     */
    public static short countToggledBits1(int value) {
        short result = 0;
        while (value != 0) {
            result += value & 1;
            //value >>= 1;//!!! Causes infinite loop 'cause sign bit is always injected.
            value >>>= 1;
        }
        return result;
    }

    /**
     * Better way. Use "check power of 2 trick".
     * O(number of toggled bits). O(log2 N) in worst case - when all bits are toggled.
     */
    public static short countToggledBits2(int value) {
        short result = 0;
        while (value != 0) {
            value &= value & (value - 1);
            result++;
        }
        return result;
    }


}
