package com.id.math.numbers;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


//leetcode
public class PowerOf3 {

    private static final int MOST_INTEGER_POWER_OF_3 = 1162261467;

    private static final int[] numbers = new int[]{
            1,
            3,
            9,
            27,
            81,
            243,
            729,
            2187,
            6561,
            19683,
            59049,
            177147,
            531441,
            1594323,
            4782969,
            14348907,
            43046721,
            129140163,
            387420489,
            MOST_INTEGER_POWER_OF_3  // <-- most 32bit power of 3
    };

    //via multiplication
    public boolean isPowerOfThree1(int n) {
        long r = 1;
        while (r < n) {
            r *= 3;
        }
        return r == n;
    }

    //via division
    public boolean isPowerOfThree2(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    //division via recursion.
    public boolean isPowerOfThree3(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        if (n % 3 == 0) {
            return isPowerOfThree3(n / 3);
        }
        return false;
    }

    public boolean isPowerOfThree4(int n) {
        return Arrays.binarySearch(numbers, n) >= 0;
    }

    //not mine
    public boolean isPowerOfThree5(int n) {
        return n > 0 && MOST_INTEGER_POWER_OF_3 % n == 0;
    }

    @Test
    public void test1() {
        assertTrue(new PowerOf3().isPowerOfThree1(1));
        assertTrue(new PowerOf3().isPowerOfThree1(3));
        assertTrue(new PowerOf3().isPowerOfThree1(27));
        assertFalse(new PowerOf3().isPowerOfThree1(0));
        assertFalse(new PowerOf3().isPowerOfThree2(2));
        assertFalse(new PowerOf3().isPowerOfThree1(62));
        assertFalse(new PowerOf3().isPowerOfThree1(-3));
    }

    @Test
    public void test2() {
        assertTrue(new PowerOf3().isPowerOfThree2(1));
        assertTrue(new PowerOf3().isPowerOfThree2(3));
        assertTrue(new PowerOf3().isPowerOfThree2(27));
        assertFalse(new PowerOf3().isPowerOfThree2(0));
        assertFalse(new PowerOf3().isPowerOfThree2(2));
        assertFalse(new PowerOf3().isPowerOfThree2(62));
        assertFalse(new PowerOf3().isPowerOfThree2(-3));
    }

    @Test
    public void test3() {
        assertTrue(new PowerOf3().isPowerOfThree3(1));
        assertTrue(new PowerOf3().isPowerOfThree3(3));
        assertTrue(new PowerOf3().isPowerOfThree3(27));
        assertFalse(new PowerOf3().isPowerOfThree3(0));
        assertFalse(new PowerOf3().isPowerOfThree3(2));
        assertFalse(new PowerOf3().isPowerOfThree3(62));
        assertFalse(new PowerOf3().isPowerOfThree3(-3));
    }

    @Test
    public void test4() {
        assertTrue(new PowerOf3().isPowerOfThree4(1));
        assertTrue(new PowerOf3().isPowerOfThree4(3));
        assertTrue(new PowerOf3().isPowerOfThree4(27));
        assertFalse(new PowerOf3().isPowerOfThree4(0));
        assertFalse(new PowerOf3().isPowerOfThree4(2));
        assertFalse(new PowerOf3().isPowerOfThree4(62));
        assertFalse(new PowerOf3().isPowerOfThree4(-3));
    }

    @Test
    public void test5() {
        assertTrue(new PowerOf3().isPowerOfThree5(1));
        assertTrue(new PowerOf3().isPowerOfThree5(3));
        assertTrue(new PowerOf3().isPowerOfThree5(27));
        assertFalse(new PowerOf3().isPowerOfThree5(0));
        assertFalse(new PowerOf3().isPowerOfThree5(2));
        assertFalse(new PowerOf3().isPowerOfThree5(62));
        assertFalse(new PowerOf3().isPowerOfThree5(-3));
    }
}