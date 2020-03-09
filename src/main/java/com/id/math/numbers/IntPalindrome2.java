package com.id.math.numbers;


import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IntPalindrome2 {

    /**
     * Check if int is palindrome in terms of decimals.
     * Example:
     * 50105 - palindrome
     * 2030 - not
     */
    public static boolean isPalindrome(int value) {
        if (value < 0) {
            return false;
        }
        int n = value;
        int power = 1;//power of 10.
        while (n >= 10) {
            power *= 10;
            n /= 10;
        }

        //check both ends of int - compare left digit and right digit.
        while (value != 0) {
            int left = value / power;
            int right = value % 10;
            if (left != right) {
                return false;
            }
            value = (value % power) / 10;
            power /= 100;
        }
        return true;
    }

    //not mine
    //problem - overflow may occur in reverse.
    public static boolean isPalindrome2(int value) {
        if (value < 0) {
            return false;
        }
        return value == ReverseInt.reverse(value);
    }

    @Test
    public void test() {
        assertFalse(isPalindrome(-10));
        assertTrue(isPalindrome(1));
        assertTrue(isPalindrome(0));
        assertTrue(isPalindrome(22));
        assertTrue(isPalindrome(1001));
        assertTrue(isPalindrome(3205023));
    }

    @Test
    public void test2() {
        assertFalse(isPalindrome2(-10));
        assertTrue(isPalindrome2(1));
        assertTrue(isPalindrome2(0));
        assertTrue(isPalindrome2(22));
        assertTrue(isPalindrome2(1001));
        assertTrue(isPalindrome2(3205023));
    }

}