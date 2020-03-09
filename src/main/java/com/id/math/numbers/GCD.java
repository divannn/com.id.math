package com.id.math.numbers;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Greatest Common Divisor - Наибольший Общий Делитель.
 */
public class GCD {

    @Test
    public void test1() {
        assertEquals(6, gcd1(24, 54));
        assertEquals(5, gcd1(5, 0));

        assertEquals(6, gcd2(24, 54));
        assertEquals(6, gcd3(24, 54));
    }

    /**
     * Via subtraction.
     * Проще сформулировать алгоритм Евклида так: если даны натуральные числа a и b,
     * пока получается ненулевое число,
     * по очереди вычитать из большего меньшее, то в результате получится НОД.
     */
    public static int gcd1(int a, int b) {
        while (a != 0 && b != 0) {
            if (a >= b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a + b; //one of them is null here.
    }

    /**
     * Via division. Same as gcd1 but faster.
     */
    public static int gcd2(int a, int b) {
        while (a != 0 && b != 0) {
            if (a >= b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }
        return a + b; //one of them is null.
    }

    /**
     * Recursive way.
     */
    public static int gcd3(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd3(b, a % b);
    }

}