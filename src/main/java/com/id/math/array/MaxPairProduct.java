package com.id.math.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Find a pair with maximum product in array of integers.
 * Consider negative values in array.
 */
public class MaxPairProduct {

    /**
     * Naive - works for non-negative values.
     *
     * @time : O(n)
     * @space: O(1)
     */
    private static long maxProduct(int[] arr) {
        if (arr == null || arr.length < 2) {
            throw new RuntimeException("Invalid array");
        }
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for (int item : arr) {
            if (max1 <= item) {
                max2 = max1;//keep previous max.
                max1 = item;
            }
        }
        return max1 * max2;
    }

    /**
     * Works for all values.
     *
     * @time : O(n)
     * @space: O(1)
     */
    private static long maxProduct2(int[] arr) {
        if (arr == null || arr.length < 2) {
            throw new RuntimeException("Invalid array");
        }
        int max = Integer.MIN_VALUE;
        int prevMax = Integer.MIN_VALUE;

        int min = Integer.MAX_VALUE;
        int prevMin = Integer.MAX_VALUE;
        for (int item : arr) {
            if (max <= item) {
                prevMax = max;//keep previous max.
                max = item;
            }
            if (min > item) {
                prevMin = min;//keep previous min.
                min = item;
            }
        }
        return Math.max(min * prevMin, max * prevMax);//product of negatives can be more.
    }

    @Test
    public void test() {
        int[] arr = {4, 5, 1, 2, 0, 3, 9};
        assertEquals(45, maxProduct2(arr));
        int[] arr2 = {0, 1, 0, 0, 1};
        assertEquals(1, maxProduct2(arr2));
        int[] arr3 = {-1, -3, -4, 2, 0, -5};
        assertEquals(20, maxProduct2(arr3));
        int[] arr4 = {2, 2, 2};
        assertEquals(4, maxProduct2(arr4));
    }
}
