package com.id.math.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Find number of equal items in sorted array.
 *
 * @company facebook
 */
public class FindEqualsObjectCountInSortedArray {

    /**
     * Recursive way.
     *
     * @time O(n)
     * @space O(log*n)
     */
    public static int findEqualsObjectCount(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int leftInd = binarySearch(array, target, 0, array.length - 1, true);
        if (leftInd == -1) {
            return -1;
        }
        int rightInd = binarySearch(array, target, 0, array.length - 1, false);
        return rightInd - leftInd + 1;
    }

    private static int binarySearch(int[] array, int target, int left, int right, boolean findFirst) {
        if (left > right) {
            return -1;
        }
        int middle = (left + right) / 2;
        if (array[middle] < target) {
            left = middle + 1;
        } else if (array[middle] > target) {
            right = middle - 1;
        } else {//MEAT - when we found first target item.
            if (findFirst && checkBounds(array, middle - 1) && array[middle - 1] == target) {
                return binarySearch(array, target, left, middle - 1, findFirst);
            }
            if (!findFirst && checkBounds(array, middle + 1) && array[middle + 1] == target) {
                return binarySearch(array, target, middle + 1, right, findFirst);
            }
            return middle;
        }
        return binarySearch(array, target, left, right, findFirst);
    }

    private static boolean checkBounds(int[] array, int ind) {
        return ind >= 0 && ind < array.length;
    }

    @Test
    public void test() {
        int[] data = {1, 1, 2, 4, 5};
        int ind = findEqualsObjectCount(data, 2);
        assertEquals(1, ind);

        int ind2 = findEqualsObjectCount(data, 15);
        assertEquals(-1, ind2);

        int ind3 = findEqualsObjectCount(data, 1);
        assertEquals(2, ind3);

        int[] data2 = new int[]{1, 1, 1, 1, 1};
        int ind4 = findEqualsObjectCount(data2, 1);
        assertEquals(5, ind4);
    }

}
