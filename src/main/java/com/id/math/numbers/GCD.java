package com.id.math.numbers;

/**
 * Finds Greatest Common Divisor - Наибольший Общий Делитель.
 */
public class GCD {

    public static void main(String[] args) {
        System.err.println("GCD for 24 and 54 = " + gcd2(24, 54));
    }

    /**
     * Via division.
     */
    public static int gcd(int a, int b) {
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
     * Via subtraction.
     * Проще сформулировать алгоритм Евклида так: если даны натуральные числа  a и b, пока получается ненулевое число,
     * по очереди вычитать из большего меньшее, то в результате получится НОД.
     */
    public static int gcd2(int a, int b) {
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
     * Recursive way.
     */
    public static int gcd3(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

}
