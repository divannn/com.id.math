package com.id.math.numbers;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Least Common Multiple - Наименьшее общее кратное
 */
public class LCM {

    @Test
    public void test1() {
        assertEquals(40, lcm(8, 10));
    }

    //HOД(a,b)*HOK(a,b) = a*b.
    public static int lcm(int a, int b) {
        int gcd = GCD.gcd1(a, b);
        return a * b / gcd;
    }
}
