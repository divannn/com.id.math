package com.id.math.cursera_algo1.w6.median;


import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Answer: 1213
 */
public class MedianMaintenance {

	public static void main(String[] args) {
		//int[] ints = readInts(MedianMaintenance.class.getResourceAsStream("2.txt"), 5000);
		int[] ints = readInts(MedianMaintenance.class.getResourceAsStream("Median.txt"), 10000);
		System.err.println(">> " + Arrays.toString(ints));
		System.err.println(">> Sum of median by modulo 10000: " + bruteForce(ints));
	}

	//TODO
	private static long findSumOfMedian(int[] ints) {
		return -1;
	}

	private static long bruteForce(int[] arr) {
		long sum = 0;
		for (int i = 0; i < arr.length; i++) {
			int[] nextSubArr = new int[i + 1];
			System.arraycopy(arr, 0, nextSubArr, 0, i + 1);
			long nextMed = findMedianBruteForce(nextSubArr);
			sum += nextMed;
			//System.err.println("M: " + sum);
		}
		return sum % 10000;
	}

	private static long findMedianBruteForce(int[] arr) {
		Arrays.sort(arr);
		long curMedian = 0;
		int len = arr.length;
		if (len % 2 == 0) {//even
			curMedian = arr[(len - 1) / 2];
		} else {//odd
			curMedian = arr[(len) / 2];
		}
//		for (int i = 0; i < arr.length; i++) {
//			if (i % 2 == 0) {
//				curMedian = arr[i / 2];
//			} else {
//				curMedian = ints[(i + 1) / 2];
//			}
//			sum += curMedian;
//		}
		return curMedian;
	}

	/*private static int find2sum(int[] ints) {
		PriorityQueue<Integer> lo = new PriorityQueue<Integer>(5000);
		for () {

		}
		//PriorityQueue<Integer> hi = new PriorityQueue<Integer>(5000, Collections.reverseOrder());
		return set.size();
	}*/

	private static int[] readInts(InputStream is, final int N) {
		int[] result = new int[N];
		Scanner s = new Scanner(is);
		int i = 0;
		while (s.hasNextInt() && i < N) {
			result[i++] = s.nextInt();
		}
		s.close();
		return result;
	}

}
