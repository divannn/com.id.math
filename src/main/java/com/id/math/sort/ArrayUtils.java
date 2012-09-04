package com.id.math.sort;

/**
 * @author idanilov
 *
 */
public final class ArrayUtils {

	public static int[] copy(int[] src) {
		int[] result = new int[src.length];
		System.arraycopy(src, 0, result, 0, src.length);
		return result;
	}

	public static void swap(int[] data, int i, int j) {
		if (data == null || i < 0 || j < 0 || data.length <= i || data.length <= j) {
			throw new IllegalArgumentException();
		}
		int tmp = data[i];
		data[i] = data[j];
		data[j] = tmp;
	}

	public static void printArray(int[] data) {
		for (int n : data) {
			System.err.print(n + " ");
		}
		System.err.println();
	}

	/**
	 * @param data
	 * @param l left index inclusive
	 * @param r right index exclusive
	 * @return miminal element in array
	 */
	public static int min(int[] data, int l, int r) {
		checkParams(data, l, r);
		int result = data[l];
		for (int i = l; i < r; i++) {
			if (data[i] < result) {
				result = data[i];
			}
		}
		return result;
	}

	/**
	 * @param data
	 * @param l left index inclusive
	 * @param r right index exclusive
	 * @return index of miminal element in array
	 */
	public static int minIndex(int[] data, int l, int r) {
		checkParams(data, l, r);
		int result = l;
		int min = data[l];
		for (int i = l; i < r; i++) {
			if (data[i] < min) {
				result = i;
				min = data[i];
			}
		}
		return result;
	}

	private static void checkParams(int[] data, int l, int r) {
		if (data == null || l < 0 || r < 0 || l > r || data.length < l || data.length < r) {
			throw new IllegalArgumentException();
		}
	}
}
