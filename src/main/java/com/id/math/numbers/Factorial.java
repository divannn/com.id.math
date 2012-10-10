package com.id.math.numbers;

import java.math.BigInteger;

/**
 * @author idanilov
 */
public class Factorial {

    public static void main(String[] args) {
        System.err.println("F1: " + factorial1(12));
        System.err.println("F2: " + factorial2(12));
        System.err.println("F3: " + factorial3(12));
    }

    //BigInteger solution.
    private static BigInteger factorial1(int N) {
        if (N < 0) {
            throw new IllegalArgumentException("Value must be positive");
        }
        //BigInteger solution.
        System.err.println("good numbers for n = " + N);
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= N; i++) {
            result = result.multiply(BigInteger.valueOf(i));
            System.err.println(" " + i + "! = " + result);
        }
        return result;
    }

    //int solution (BAD IDEA BECAUSE ONLY WORKS TO 12).
    private static int factorial2(int N) {
        if (N < 0) {
            throw new IllegalArgumentException("Value must be positive");
        }
        System.err.println("bad numbers for n = " + N);
        int result = 1;
        for (int i = 1; i <= N; i++) {
            result *= i;
            System.err.println(" " + i + "! = " + result);
        }
        return result;
    }

    //recursive way(also BAD).
    private static int factorial3(int N) {
        if (N < 0) {
            throw new IllegalArgumentException("Value must be positive");
        }
        return (N == 0) ? 1 : N * factorial3(N - 1);
    }

}
