package com.id.math.numbers;

import com.id.math.util.ArrayUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author idanilov
 */
public class PrimeNumbers {


    public static void main(String[] args) {
        ArrayUtils.printArray(sieve(50));
        ArrayUtils.printArray(sieve2(50));
    }

    /**
     * Eratosthenes sieve.
     * Retruens prime number up to limit.
     */
    private static int[] sieve(int limit) {
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
                sieve[sieveSize++] = i;
            }
        }
        return Arrays.copyOf(sieve, sieveSize);
    }

    //way2. similar but no exra memory for sieve.
    private static int[] sieve2(int limit) {
        List<Integer> result = new ArrayList<>();

        for (int i = 2; i <= limit; i++) {
            boolean isPrime = true;
            for (int j = 2; j * j <= limit; j++) {
                if (i > j && i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                result.add(i);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }


    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                System.err.printf("For %s divisor is: %s %n", number, i);
                return false;
            }
        }
        return true;
    }

    @Test
    public void testPrime() {
        assertFalse(isPrime(-4));
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

    @Test
    public void testEratosphenSieve() {
        int[] sieve = sieve(50);
        assertEquals(15, sieve.length);
        assertEquals(2, sieve[0]);
        assertEquals(47, sieve[14]);

        int[] sieve2 = sieve(50);
        assertEquals(15, sieve2.length);
        assertEquals(2, sieve2[0]);
        assertEquals(47, sieve2[14]);
    }
}
