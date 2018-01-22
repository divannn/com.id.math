package com.id.math.sort;


import com.id.math.util.ArrayUtils;

/**
 * @author idanilov
 * @complexity in worse case : O(n*n), in worse case : O(n*ln(n)).
 * @stable false
 */
public class QuickSort extends AbstractSort {

    /**
     * quicksort the array in-place.
     *
     * @param arr to be sorted
     */
    public int[] sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
        return arr;
    }

    /**
     * quicksort the sub-array from arr[lo] to arr[hi] in-place.
     *
     * @param arr
     * @param lo  - low index inclusive
     * @param hi  - high index inclusive
     */
    private static void sort(int[] arr, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int pivot_pos = partition(arr, lo, hi);
        sort(arr, lo, pivot_pos - 1);
        sort(arr, pivot_pos + 1, hi);
    }

    /**
     * Partition the sub-array a[lo .. hi] by returning an index j
     * so that a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
     *
     * @return pivot position
     */
    private static int partition(int[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int pivot = a[lo];//just take 1st item.
        while (i < j) {
            // find item on lo to swap
            while (a[++i] < pivot) {
                if (i == hi) break;
            }
            // find item on hi to swap
            while (pivot < a[--j]) {
                if (j == lo) break;      // redundant since a[lo] acts as sentinel
            }

            // check if pointers cross
            if (i < j) {
                ArrayUtils.swap(a, i, j);
            }
        }

        // put pivot = a[j] into position
        ArrayUtils.swap(a, lo, j);

        // with a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return j;
    }

    public static void main(String[] args) {
        System.err.println("-=QUICK SORT=-");
        int[] source = TestData.RANDOM;
        System.err.println("Source:");
        ArrayUtils.printArray(source);

        int[] result = new QuickSort().sort(source);
        System.err.println("Result:");
        ArrayUtils.printArray(result);
    }

}
