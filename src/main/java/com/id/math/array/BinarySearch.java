package com.id.math.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinarySearch {

    public static int binarySearch(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;//take care about overflow
            if (array[middle] < target) {
                left = middle + 1;
            } else if (array[middle] > target) {
                right = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    //recursive way.
    public static int binarySearch2(int[] array, int target) {
        return binarySearch2(array, target, 0, array.length - 1);
    }

    private static int binarySearch2(int[] array, int target, int left, int right) {
        if (array == null || array.length == 0) {
            return -1;
        }
        if (left > right) {
            return -1;
        }
        int middle = left + (right - left) / 2;//take care about overflow
        if (array[middle] < target) {
            left = middle + 1;
        } else if (array[middle] > target) {
            right = middle - 1;
        } else {
            return middle;
        }
        return binarySearch2(array, target, left, right);
    }

    @Test
    public void testIter() {
        int[] data = {-2, 1, 2, 4, 5, 7, 7, 11};
        int ind = binarySearch(data, 2);
        assertEquals(2, ind);

        int ind2 = binarySearch(data, 15);
        assertEquals(-1, ind2);

        int ind3 = binarySearch(data, 11);
        assertEquals(7, ind3);

        int ind4 = binarySearch(data, 7);
        assertEquals(5, ind4);

    }

    @Test
    public void testRecur() {
        int[] data = {-2, 1, 2, 4, 5, 7, 7, 11};
        int ind = binarySearch2(data, 2);
        assertEquals(2, ind);

        int ind2 = binarySearch2(data, 15);
        assertEquals(-1, ind2);

        int ind3 = binarySearch2(data, 11);
        assertEquals(7, ind3);
    }

}
