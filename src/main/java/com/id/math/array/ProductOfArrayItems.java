package com.id.math.array;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Given an array calculate new array of same size where each item in position i is multiplication of all elements in source array expect item i.
 * Don't worry about overflows when multiply.
 * <p>
 * Example:
 * <p>
 * Input array = [1,2,3,4,5]
 * <p>
 * Output result = [2*3*4*5, 1*3*4*5, 1*2*4*5, 1*2*3*5, 1*2*3*4]
 *
 * @company facebook (I was asked)
 */
public class ProductOfArrayItems {

    private static final int[] A1 = {5};
    private static final int[] A2 = {1, 2, 3, 4};
    private static final int[] A3 = {1, 0, 2};

    private static final long[] EXPECTED_A1 = {5};
    private static final long[] EXPECTED_A2 = {24, 12, 8, 6};
    private static final long[] EXPECTED_A3 = {0, 2, 0};


    /**
     * Naive.
     *
     * @param arr - source
     * @return result
     * @time O(n * n)
     * @space O(1)
     */
    public long[] calculateNaive(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new long[0];
        }
        if (arr.length == 1) {
            return new long[]{arr[0]};
        }
        long[] result = new long[arr.length];
        for (int i = 0; i < arr.length; i++) {
            long mul = 1;
            for (int j = 0; j < arr.length; j++) {
                if (i != j) {
                    mul *= arr[j];
                }
            }
            result[i] = mul;
        }
        return result;
    }

    /**
     * Via division - Smart but doesn't work if array contains zero.
     * <p>
     * Observation:
     * <p>
     * If array contains two zeros ore more - all resulting items will be zero as well.
     * If array contains one zero at som index - we can calculate resulting item for that index only (others will be zero).
     *
     * @param arr source array
     * @return new array containing multiplication
     * @time O(n)
     * @space O(1)
     */
    public long[] calculateViaDivision(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new long[0];
        }
        if (arr.length == 1) {
            return new long[]{arr[0]};
        }
        long mul = 1;
        for (int i : arr) {
            if (i != 0) {
                mul *= i;
            }
        }
        long[] result = new long[arr.length];
        for (int i = 0; i < result.length; i++) {
            if (arr[i] != 0) {
                result[i] = mul / arr[i];
            }
        }
        return result;
    }

    /**
     * Do NOT use division!
     *
     * @param arr source array
     * @return new array containing multiplication
     * @time O(n)
     * @space O(n)
     */
    public long[] calculateSmart(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new long[0];
        }
        if (arr.length == 1) {
            return new long[]{arr[0]};
        }

        long[] left_product = new long[arr.length];//holds in index i product of all items[i] where < i
        left_product[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            left_product[i] = left_product[i - 1] * arr[i - 1];
        }

        long[] right_product = new long[arr.length];//holds in index i product of all items[i] where > i
        right_product[right_product.length - 1] = 1;
        for (int i = arr.length - 2; i >= 0; i--) {
            right_product[i] = right_product[i + 1] * arr[i + 1];
        }

        long[] result = new long[arr.length];
        //for each i just multiply left product and right product..
        for (int i = 0; i < result.length; i++) {
            result[i] = left_product[i] * right_product[i];
        }
        return result;
    }

    @Test
    public void testNaive() {
        assertArrayEquals(EXPECTED_A1, calculateSmart(A1));
        assertArrayEquals(EXPECTED_A2, calculateNaive(A2));
        assertArrayEquals(EXPECTED_A3, calculateNaive(A3));
    }

    @Test
    public void testCalculateViaDivision() {
        assertArrayEquals(EXPECTED_A1, calculateSmart(A1));
        assertArrayEquals(EXPECTED_A2, calculateViaDivision(A2));
        assertArrayEquals(EXPECTED_A3, calculateViaDivision(A3));//will fail because of 0.
    }

    @Test
    public void testCalculateSmart() {
        assertArrayEquals(EXPECTED_A1, calculateSmart(A1));
        assertArrayEquals(EXPECTED_A2, calculateSmart(A2));
        assertArrayEquals(EXPECTED_A3, calculateSmart(A3));
    }
}
