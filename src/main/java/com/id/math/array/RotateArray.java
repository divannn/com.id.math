package com.id.math.array;

import com.id.math.util.ArrayUtils;
import com.id.math.numbers.GCD;

/**
 * Rotate array to the left cyclically.
 * Having array: 1 2 3 4 5 6 7.
 * Rotation of the above array by 2 will make array: 3 4 5 6 7 1 2.
 */
public class RotateArray {

    public static void main(String[] args) {
        int[] data = {-2, 1, 0, 4, 5};
        ArrayUtils.printArray(data);
        //rotateLeft1(data, 2);
        rotateLeft2(data, 2);
        ArrayUtils.printArray(data);
    }

    /**
     * Time complexity: O(n*shift)
     * Auxiliary Space: O(1)
     */
    public static void rotateLeft1(int[] array, int shift) {
        if (shift <= 0 || array == null || array.length <= shift) {
            throw new IllegalArgumentException("Invalid args");
        }
        for (int i = 0; i < shift; i++) {
            leftRotateByOne(array);
        }
    }

    /**
     * Rotate by 1.
     */
    private static void leftRotateByOne(int[] array) {
        int tmp = array[0];
        for (int i = 0; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        array[array.length - 1] = tmp;
    }

    /**
     * Better solution.
     * Time complexity: O(n)
     * Auxiliary Space: O(1)
     */
    public static void rotateLeft2(int[] array, int shift) {
        if (shift <= 0 || array == null || array.length <= shift) {
            throw new IllegalArgumentException("Invalid args");
        }
        int n = array.length;
        int i, j, k, temp;
        for (i = 0; i < GCD.gcd1(shift, n); i++) {
            /* move i-th values of blocks */
            temp = array[i];
            j = i;
            while (true) {
                k = j + shift;
                if (k >= n) {
                    k = k - n;
                }
                if (k == i) {
                    break;
                }
                array[j] = array[k];
                j = k;
            }
            array[j] = temp;
        }
    }

}
