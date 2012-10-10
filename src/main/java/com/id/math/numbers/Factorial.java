package com.id.math.numbers;

import java.math.BigInteger;

/**
 * @author idanilov
 */
public class Factorial {

    public static void main(String[] args) {
        factorial1(20);
        factorial2(10);
    }

    //BigInteger solution.
    private static void factorial1(int num) {
        //BigInteger solution.
        System.out.println("good numbers for n = " + num);
        BigInteger n = BigInteger.ONE;
        for (int i = 1; i <= num; i++) {
            n = n.multiply(BigInteger.valueOf(i));
            System.out.println(" " + i + "! = " + n);
        }
    }

    //int solution (BAD IDEA BECAUSE ONLY WORKS TO 12).
    private static void factorial2(int n) {
        System.out.println("bad numbers for n = " + n);
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact = fact * i;
            System.out.println(" " + i + "! = " + fact);
        }
    }

    //recursive way(also BAD).
    private static int factorial3(int n) {
        return (n == 0) ? 1 : n * factorial3(n - 1);
    }

}
