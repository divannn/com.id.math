package com.id.math.array;

import static org.junit.Assert.assertArrayEquals;

/**
 * A sorted array of distinct integers shiftArr is shifted to the left by an unknown offset and you don’t have a pre-shifted copy of it.
 * For instance, the sequence 1, 2, 3, 4, 5 becomes 3, 4, 5, 1, 2, after shifting it twice to the left.
 * Given shiftArr and an integer num, implement a function shiftedArrSearch that finds and returns the index of num in shiftArr.
 * If num isn’t in shiftArr, return -1. Assume that the offset doesn’t equal to 0 (i.e. assume the array is shifted at least once) or to arr.length - 1
 * (i.e. assume the shifted array isn’t fully reversed).
 */
public class FindInRotatedArray {
    static int shiftedArrSearch(int[] shiftArr, int num) {
        if (shiftArr == null) {
            return -1;
        }
        if (shiftArr.length == 1) {
            return num == shiftArr[0] ? 0 : -1;
        }
        int pivotInd = getPivotIndex(shiftArr);
        System.out.println("Pivot : " + pivotInd);
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
        int cur = arr[0];
        int i = 1;
        boolean found = false;
        for (; i < arr.length; i++) {
            if (cur < arr[i]) {
                cur = arr[i];
            } else {
                found = true;
                break;
            }
        }
        return found ? i : 0;
    }

    static int bs(int[] arr, int num, int lo, int hi) {
        while (lo <= hi) {
            int mid = (lo+hi)/2;
            if (num == arr[mid]) {
                return mid;
            } else if (num < arr[mid] ) {
                hi = mid - 1;
            } else if (num > arr[mid] ) {
                lo = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int r = shiftedArrSearch(new int [] {3,4,5,1,2}, 4);
        System.out.println("Res : " + r);
    }

}

