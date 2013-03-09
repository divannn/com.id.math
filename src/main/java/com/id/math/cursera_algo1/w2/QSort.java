package com.id.math.cursera_algo1.w2;


import com.id.math.util.ArrayUtils;

/**
 * @author idanilov
 * @complexity in worse case : O(n*n), in worse case : O(n*ln(n)).
 * @stable false
 */
class QSort {

	public enum PIVOT_STRATEGY {
		FIRST, LAST, MEDIAN
	}

	//number of comparisons.
	public static int count;

	// quicksort the array
	public int[] sort(int[] a, PIVOT_STRATEGY ps) {
		count = 0;
		sort(a, 0, a.length - 1, ps);
		return a;
	}

	// quicksort the subarray from a[lo] to a[hi]
	private static void sort(int[] a, int lo, int hi, PIVOT_STRATEGY ps) {
		if (hi <= lo) {
			return;
		}

		switch (ps) {
			case FIRST:
				//nothing
				break;
			case LAST:
				ArrayUtils.swap(a, lo, hi);
				break;
			case MEDIAN:
				int med_ind = findMedian(a, lo, hi);
				ArrayUtils.swap(a, lo, med_ind);
				break;
			default:

		}

		count += (hi - lo);

		int pivot_pos = partition(a, lo, hi);
		sort(a, lo, pivot_pos - 1, ps);
		sort(a, pivot_pos + 1, hi, ps);
	}

	/**
	 * partition the subarray a[lo .. hi] by returning an index j
	 * so that a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
	 *
	 * @return pivot position
	 */
	private static int partition(int[] a, int lo, int hi) {
		int i = lo + 1;
		int pivot = a[lo];//just take 1st item.
		for (int j = i; j <= hi; j++) {
			if (a[j] < pivot) {
				ArrayUtils.swap(a, j, i);
				i++;
			}
		}
		ArrayUtils.swap(a, lo, i - 1);
		//System.err.println(">>" + Arrays.toString(a));
		return i - 1;
	}

	//return index of median among 2 items.
	private static int findMedian(int[] a, int lo, int hi) {
		//int mid = lo + (hi - lo)/2;
		int mid_ind = (hi + lo) / 2;
		/*System.err.println("------------------");
				for (int i = 0; i < a.length; i++) {
					System.err.print(a[i] + " ");
				}
				System.err.println();
				System.err.println(" {" + lo + " " + mid_ind + " " + hi + "}");*/
		int result = -1;
		if ((a[lo] <= a[mid_ind] && a[mid_ind] <= a[hi])
				|| (a[hi] <= a[mid_ind] && a[mid_ind] <= a[lo])) {
			result = mid_ind;
		} else if ((a[lo] <= a[hi] && a[hi] <= a[mid_ind])
				|| (a[mid_ind] <= a[hi] && a[hi] <= a[lo])) {
			result = hi;
		} else {
			result = lo;
		}
		/*System.err.println("       " + a[lo] + " " + a[mid_ind] + " " + a[hi]);
				System.err.println("          med = " + a[r]);*/
		return result;
	}


}
