package com.id.math.prime;

import com.id.math.util.ArrayUtils;
import com.sun.deploy.util.ArrayUtil;

import java.util.Arrays;

/**
 * @author idanilov
 *
 */
public class PrimeNumbers {

	final static int MAX = 50;//range to array.

	public static void main(String[] args) {
		int[] primes = findPrimeNumbers(MAX);
        ArrayUtils.printArray(primes);
	}

	private static int[] findPrimeNumbers(int limit) {
		int[] sieve = new int[limit];
		sieve[0] = 2;//first element is 2.
		int sieveSize = 1;//size of sieve.
		for (int i = 3; i <= MAX; i += 2) {//optimization - step with 2 (filter all even elements after 2).
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
}
