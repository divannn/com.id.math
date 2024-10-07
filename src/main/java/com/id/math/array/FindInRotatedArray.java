package com.id.math.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * A sorted array of distinct integers shiftArr is shifted to the left by an unknown offset and you don’t have a pre-shifted copy of it.
 * For instance, the sequence 1, 2, 3, 4, 5 becomes 3, 4, 5, 1, 2, after shifting it twice to the left.
 * Given shiftArr and an integer num, implement a function shiftedArrSearch that finds and returns the index of num in shiftArr.
 * If num isn’t in shiftArr, return -1. Assume that the offset doesn’t equal to 0 (i.e. assume the array is shifted at least once) or to arr.length - 1
 * (i.e. assume the shifted array isn’t fully reversed).
 */
//pramp
public class FindInRotatedArray {

    private static int shiftedArrSearch(int[] shiftArr, int num) {
        if (shiftArr == null || shiftArr.length == 0) {
            return -1;
        }
        if (shiftArr.length == 1) {
            return num == shiftArr[0] ? 0 : -1;
        }
        int pivotInd = getPivotIndex(shiftArr);
        //System.out.println("Pivot ind: " + pivotInd);
        if (shiftArr[pivotInd] == num) {
            return pivotInd;
        }
        if (pivotInd == 0 || num < shiftArr[0]) {
            return bs(shiftArr, num, pivotInd, shiftArr.length - 1);
        }

        return bs(shiftArr, num, 0, pivotInd - 1);
    }

    //finds index of shift (index of minimal element).
    static int getPivotIndex(int[] arr) {
        int i = 0;
        boolean found = false;
        for (; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                found = true;
                break;
            }
        }
        return found ? i : 0;
    }

    private static int bs(int[] arr, int num, int lo, int hi) {
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (num == arr[mid]) {
                return mid;
            } else if (num < arr[mid]) {
                hi = mid - 1;
            } else if (num > arr[mid]) {
                lo = mid + 1;
            }
        }
        return -1;
    }


    @Test
    public void test() {
        int r = shiftedArrSearch(new int[]{}, 2);
        assertEquals(-1, r);

        r = shiftedArrSearch(new int[]{3}, 5);
        assertEquals(-1, r);

        r = shiftedArrSearch(new int[]{3}, 3);
        assertEquals(0, r);

        r = shiftedArrSearch(new int[]{3, 4, 5, 1, 2}, 4);
        assertEquals(1, r);

        r = shiftedArrSearch(new int[]{3, 4, 5, 1, 2}, 4);
        assertEquals(1, r);

        r = shiftedArrSearch(new int[]{1, 2, 3, 4, 5}, 4);
        assertEquals(3, r);
    }

}

