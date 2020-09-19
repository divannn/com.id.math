package com.id.math.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Find a pair with maximum product in array of integers.
 * Consider negative values in array.
 */
public class MaxPairProduct {

    // naive - works for non-negative values.
    private static long maxProduct(int[] arr) {
        if (arr == null || arr.length < 2) {
            throw new RuntimeException("Invalid array");
        }
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (max1 < arr[i]) {
                max2 = max1;//keep previous max.
                max1 = arr[i];
            }
        }
        return max1 * max2;
    }

    // works for all values.
    private static long maxProduct2(int[] arr) {
        if (arr == null || arr.length < 2) {
            throw new RuntimeException("Invalid array");
        }
        //max
        int max1 = Integer.MIN_VALUE;
        //previous max
        int max2 = Integer.MIN_VALUE;

        //min
        int min1 = Integer.MAX_VALUE;
        //previous min
        int min2 = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (max1 < arr[i]) {
                max2 = max1;//keep previous max.
                max1 = arr[i];
            }
            if (min1 > arr[i]) {
                min2 = min1;//keep previous min.
                min1 = arr[i];
            }
        }
        if (min1 * min2 > max1 * max2) {
            return min1 * min2;//product of negatives can be more.
        } else {
            return max1 * max2;
        }
    }

    @Test
    public void test() {
        int[] arr = {4, 5, 1, 2, 0, 3, 9};
        assertEquals(45, maxProduct2(arr));
        int[] arr2 = {0, 1, 0, 0, 1};
        assertEquals(0, maxProduct2(arr2));
        int[] arr3 = {-1, -3, -4, 2, 0, -5};
        assertEquals(20, maxProduct2(arr3));
    }
}
