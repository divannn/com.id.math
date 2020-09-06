package com.id.math.geom;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Largest Rectangle in Histogram.
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 * Example, [1,2,1] -> 3
 *
 * //leetcode
 * https://leetcode.com/problems/largest-rectangle-in-histogram/description/
 */
public class LargestRectangleArea {

    //naive
    //@time: O(n*n)
    private static int find(int[] histogram) {
        int result = 0;
        for (int i = 0; i < histogram.length; i++) {
            int minHeight = histogram[i];
            for (int j = i; j < histogram.length; j++) {
                minHeight = Math.min(minHeight, histogram[j]);
                result = Math.max(result, minHeight * (j - i + 1));//square.
            }
        }
        return result;
    }

    //TODO - implement fast solution

    @Test
    public void test() {
        int[] data0 = {2};
        assertEquals(2, find(data0));
        int[] data1 = {2, 1, 5, 6, 2, 3};
        assertEquals(10, find(data1));
        int[] data2 = {4, 3, 4};
        assertEquals(9, find(data2));
        int[] data3 = {5, 5};
        assertEquals(10, find(data3));
    }
}
