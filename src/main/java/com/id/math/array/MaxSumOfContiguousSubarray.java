package com.id.math.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * Given an aray of integers find a maximum sum of a contiguous subarray of source array.
 * <p>
 * Example:
 * Input: [-2,0,1,3]
 * Output: 4
 */
public class MaxSumOfContiguousSubarray {

    private static final int[] A1 = {5};
    private static final int[] A2 = {1, 2, 3, 4};
    private static final int[] A3 = {1, 0, 2};
    private static final int[] A4 = {-1, 2, 3, -2, 3};
    private static final int[] A5 = {-2, 2, 5, -9, 6};

    private static final int EXPECTED_1 = 5;
    private static final int EXPECTED_2 = 10;
    private static final int EXPECTED_3 = 3;
    private static final int EXPECTED_4 = 6;
    private static final int EXPECTED_5 = 7;

    /**
     * Naive
     *
     * @param arr - source
     * @return max sum of subarray
     * @time O(n * n)
     */
    private static int naive(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new RuntimeException("Invalid array");
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int curSum = 0;
            for (int j = i; j < arr.length; j++) {
                curSum += arr[j];
                max = Math.max(max, curSum);
            }
        }
        return max;
    }

    /**
     * Kadane's algorithm
     *
     * @param arr - source
     * @return max sum of subarray
     * @time O(n)
     */
    private static long kadane(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new RuntimeException("Invalid array");
        }
        int curSum = arr[0];
        int max = curSum;
        for (int i = 1; i < arr.length; i++) {
            curSum = Math.max(curSum + arr[i], arr[i]);// what is greater: (previous sum + item) or item itself?
            max = Math.max(curSum, max);
        }
        return max;
    }

    @Test
    public void testNaive() {
        Assert.assertEquals(EXPECTED_1, naive(A1));
        Assert.assertEquals(EXPECTED_2, naive(A2));
        Assert.assertEquals(EXPECTED_3, naive(A3));
        Assert.assertEquals(EXPECTED_4, naive(A4));
        Assert.assertEquals(EXPECTED_5, naive(A5));
    }

    @Test
    public void testKadane() {
        Assert.assertEquals(EXPECTED_1, kadane(A1));
        Assert.assertEquals(EXPECTED_2, kadane(A2));
        Assert.assertEquals(EXPECTED_3, kadane(A3));
        Assert.assertEquals(EXPECTED_4, kadane(A4));
        Assert.assertEquals(EXPECTED_5, kadane(A5));
    }

}
