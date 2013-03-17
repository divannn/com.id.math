package com.id.math.cursera_algo1.w6.two_sum;


import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Answer: 1477
 */
public class TwoSum {

	public static void main(String[] args) {
		int[] ints = readInts(TwoSum.class.getResourceAsStream("HashInt.txt"), 500000);
		//int[] ints = readInts(TwoSum.class.getResourceAsStream("TwoSumMedium.txt"), 100);
		//System.err.println(">> " + Arrays.toString(ints));

		int lo = 2500, hi = 4000;//inclusive.
		//int lo = 60, hi = 100;//inclusive.
		int len = hi - lo + 1;
		int[] toVerify = new int[len];
		for (int i = 0; i < len; i++) {
			toVerify[i] = lo + i;
		}
		System.err.println(">> " + Arrays.toString(toVerify));
		System.err.println(">> Distinct (x,y) 2 sum:" + find2sum(ints, toVerify));
	}

	private static int find2sum(int[] ints, int[] toVerify) {
		Arrays.sort(ints);
		HashSet<Integer> set = new HashSet<Integer>(10000);//to count distinct 2sum.
		for (int next2Verify : toVerify) {
			//System.err.println("t = " + next2Verify);
			for (int x : ints) {
				int y = next2Verify - x;
				if (x != y) {
					int index = Arrays.binarySearch(ints, y);
					if (index > -1) {
						set.add(next2Verify);
						//System.err.println("    ?> " + x + " " + y);
					}
				}
			}
		}
		return set.size();
	}

	//too long - don't call.
	private static int bruteForce(int[] ints, int[] toVerify) {
		HashSet<Integer> set = new HashSet<Integer>(10000);//to count distinct 2sum.
		for (int next2Verify : toVerify) {
			//System.err.println("t = " + next2Verify);
			for (int i = 0; i < ints.length; i++) {
				for (int j = i + 1; j < ints.length; j++) {
					if ((ints[i] + ints[j] == next2Verify)) {
						set.add(next2Verify);
						//System.err.println("    ?> " + ints[i] + " " + ints[j]);
					}
				}
			}
		}
		return set.size();
	}

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
