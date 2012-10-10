package com.id.math.numbers;

import java.math.BigInteger;

/**
 * @author idanilov
 */
public class Factorial {

    public static void main(String[] args) {
        factorial1(0);
        factorial2(10);
    }

    //BigInteger solution.
    private static void factorial1(int N) {
        if (N < 0) {
            throw new IllegalArgumentException("Value must be positive");
        }
        //BigInteger solution.
        System.out.println("good numbers for n = " + N);
        BigInteger next = BigInteger.ONE;
        for (int i = 1; i <= N; i++) {
            next = next.multiply(BigInteger.valueOf(i));
            System.out.println(" " + i + "! = " + next);
        }
    }

    //int solution (BAD IDEA BECAUSE ONLY WORKS TO 12).
    private static void factorial2(int N) {
        if (N < 0) {
            throw new IllegalArgumentException("Value must be positive");
        }
        System.out.println("bad numbers for n = " + N);
        int fact = 1;
        for (int i = 1; i <= N; i++) {
            fact = fact * i;
            System.out.println(" " + i + "! = " + fact);
        }
    }

    //recursive way(also BAD).
    private static int factorial3(int N) {
        if (N < 0) {
            throw new IllegalArgumentException("Value must be positive");
        }
        return (N == 0) ? 1 : N * factorial3(N - 1);
    }

}
