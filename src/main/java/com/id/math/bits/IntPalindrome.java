package com.id.math.bits;


import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IntPalindrome {

    /** Check if int is palindrome in terms of bits set.
     * Example for 4 bit int:
     * 1001 - palindrome
     * 1010 - not
     */
    public static boolean isPalindrome(int value) {
        for (int i = 0, j = 31; i < 16 && j >=16; i++, j--) {
            boolean isRightBitSet = (value & (1 << i)) != 0;
            boolean isLeftBitSet = (value & (1 << j)) != 0;
            if (isLeftBitSet != isRightBitSet) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        assertFalse(isPalindrome(1));
        assertTrue(isPalindrome(0xFFFF_FFFF));
        assertTrue(isPalindrome(0xFF00_00FF));
    }

    public static void main(String[] args) {
        System.err.println("AA " + to(1 << 0));
        System.err.println("AA " + to(1 << 1));
        System.err.println("AA " + to(-1>> 2));
        System.err.println("AA " + to(-1 >>> 2));

    }

    private static String to(int i) {
        StringBuilder sb = new StringBuilder();
        for (int j = 31; j >= 0; j--) {
            boolean set = (i & (1 << j)) != 0;
            sb.append(set ? "1" : "0");
        }
        return sb.toString();
    }

}
