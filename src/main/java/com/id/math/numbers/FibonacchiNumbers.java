package com.id.math.numbers;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author idanilov
 */
public class FibonacchiNumbers {

    private static long counter;//num invocations.

    public static void main(String[] args) {
        final int NUM = 43;
        long s1 = System.currentTimeMillis();
        System.err.println("1way result: " + fib1(NUM));
        long e1 = System.currentTimeMillis();
        System.err.println("time: " + (e1 - s1) / 1000.0);
        System.err.println("num invocations: " + counter);

        long s2 = System.currentTimeMillis();
        System.err.println("2way result: " + fib2(NUM));
        long e2 = System.currentTimeMillis();
        System.err.println("2way time: " + (e2 - s2) / 1000.0);
    }

    /**
     * Bad way. Complexity is 2^n.
     *
     * @param n number staring from 1
     * @return nth Fibonacci number
     */
    private static long fib1(long n) {
        counter++;
        if (n <= 0) {
            throw new IllegalArgumentException("value must > 0");
        }
        if (n <= 2) {
            return 1;
        }
        return fib1(n - 1) + fib1(n - 2);
    }

    /**
     * @param n number staring from 1
     * @return nth Fibonacci number
     */
    private static long fib2(long n) {
        if (n <= 0) {
            return -1;
        }
        long f1 = 1;
        long f2 = 1;
        for (int i = 3; i <= n; i++) {
            long tmp = f2;
            f2 = f1 + f2;
            f1 = tmp;
        }
        return f2;
    }

    @Test
    public void test2() {
        assertEquals(-1,fib2(-1)) ;
        assertEquals(-1,fib2(0)) ;
        assertEquals(1,fib2(2)) ;
        assertEquals(2,fib2(3)) ;
    }

}
