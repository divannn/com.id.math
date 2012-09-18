package com.id.math.util;

public class GCD {

    public static void main(String[] args) {
        System.err.println("GCD for 24 and 54 = " + gcd2(54, 24));
    }

    /** Finds Greatest Common Divisor - Наибольший Общий Делитель.*/
    public static int gcd(int a, int b) {
        while (a != 0 && b != 0) {
            if (a >= b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }
        return a + b; //One of them is null.
    }
    /**
     * Recursive way.
     */
    public static int gcd2(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

}
