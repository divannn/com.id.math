package com.id.math.sort;


import com.id.math.util.ArrayUtils;

import java.util.Arrays;

/**
 * @author idanilov
 * @time in worse case : O(n)
 * @stable true
 */
public class RadixSort extends AbstractSort {

    public int[] sort(int[] d) {
        data = ArrayUtils.copy(d);

        int n = data.length;
        // Find the maximum number to know number of digits
        int m = getMax(data, n);

        // Do counting sort for every digit. Note that instead
        // of passing digit number, exp is passed. exp is 10^i
        // where i is current digit number
        for (int exp = 1; m / exp > 0; exp *= 10) {
            countSort(data, n, exp);
        }
        return data;
    }

    //Returns maximum value in arr[]
    private static int getMax(int arr[], int n) {
        int result = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > result) {
                result = arr[i];
            }
        }
        return result;
    }

    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    static void countSort(int arr[], int n, int exp) {
        final int BASE = 10;
        int output[] = new int[n];
        int count[] = new int[BASE]; //per 10-based numbers.
        Arrays.fill(count, 0);

        int i;
        // Store count of occurrences in count[]
        for (i = 0; i < n; i++) {
            int digit = (arr[i] / exp) % BASE;
            count[digit]++;
        }

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < BASE; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % BASE;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to current digit
        for (i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    public static void main(String[] args) {
        System.err.println("-=RADIX SORT=-");
        int[] source = TestData.RANDOM;
        System.err.println("Source:");
        ArrayUtils.printArray(source);

        int[] result = new RadixSort().sort(source);
        System.err.println("Result:");
        ArrayUtils.printArray(result);
    }
}
