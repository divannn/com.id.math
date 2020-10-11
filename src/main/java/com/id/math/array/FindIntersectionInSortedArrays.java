package com.id.math.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Given a two sorted arrays find a number of equal items in them.
 * Arrays are the same length and each has distinct numbers.
 * Example:
 * <p/>
 * Input:
 * <p/>
 * a1 = [13, 27, 35, 40, 49, 51, 55]
 * <p/>
 * a2 = [17, 35, 39, 40, 55, 80, 90]
 * <p/>
 * Output:
 * 3 (35, 40, 55)
 *
 * @company yandex (I was asked)
 */

public class FindIntersectionInSortedArrays {

    public int solution(int[] a1, int[] a2) {
        if (a1 == null || a1.length == 0 || a2 == null || a2.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        int result = 0;
        int i = 0;
        int j = 0;
        while (i < a1.length && j < a2.length) {
            if (a1[i] < a2[j]) {
                i++;
            } else if (a1[i] > a2[j]) {
                j++;
            } else {
                result++;
                i++;
                j++;
            }
        }
        return result;
    }

    @Test
    public void test() {
        int[] a1 = new int[]{1};
        int[] a2 = new int[]{2};
        assertEquals(0, solution(a1, a2));

        a1 = new int[]{1, 2};
        a2 = new int[]{2, 3};
        assertEquals(1, solution(a1, a2));

        a1 = new int[]{13, 27, 35, 40, 49, 51, 55};
        a2 = new int[]{17, 35, 39, 40, 55, 80, 90};
        assertEquals(3, solution(a1, a2));
    }
}
