package com.id.math.numbers;

import com.id.math.util.ArrayUtils;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author idanilov
 */
public class PrimeNumbers {

    final static int MAX = 50;

    public static void main(String[] args) {
        int[] primes = findPrimeNumbers(MAX);
        ArrayUtils.printArray(primes);
    }

    private static int[] findPrimeNumbers(int limit) {
        int[] sieve = new int[limit];
        sieve[0] = 2;//first element is 2.
        int sieveSize = 1;//size of sieve.
        for (int i = 3; i <= limit; i += 2) {//optimization - step with 2 (filter all even elements after 2).
            boolean isPrime = true;
            for (int j = 0; j < sieveSize; j++) {
                if (i % sieve[j] == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                sieve[sieveSize++] = i;//save prime number.
            }
        }
        return Arrays.copyOf(sieve, sieveSize);
    }


    private static boolean isPrime(int limit) {
        if (limit <= 1) {
            return false;
        }

        for (int i = 2; i * i <= limit; i++) {
            if (limit % i == 0) {
                System.err.printf("For %s divisor is: %s %n", limit, i);
                return false;
            }
        }
        return true;
    }

    @Test
    public void test1() {
        assertFalse(isPrime(1));
        assertFalse(isPrime(4));
        assertFalse(isPrime(100));

        assertTrue(isPrime(2));
        assertTrue(isPrime(3));
        assertTrue(isPrime(5));
        assertTrue(isPrime(7));
        assertTrue(isPrime(11));
        assertTrue(isPrime(97));
    }

}
