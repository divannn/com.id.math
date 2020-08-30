package com.id.math.array;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Rotate array to the left cyclically.
 * Having array: 1 2 3 4 5 6 7.
 * Rotation of the above array by 2 will make array: 3 4 5 6 7 1 2.
 */
public class RotateArray {

    /**
     * @complexity O(n * shift)
     * Space: O(1)
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
     * Rotate array to the left by 1.
     */
    private static void leftRotateByOne(int[] array) {
        int tmp = array[0];
        for (int i = 0; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        array[array.length - 1] = tmp;
    }

    /**
     * @complexity O(n)
     * Space: O(1)
     * Not mine - really smart!
     */
    public static void rotateLeft2(int[] array, int shift) {
        if (shift <= 0 || array == null || array.length <= shift) {
            throw new IllegalArgumentException("Invalid args");
        }
        reverse(array, 0, shift - 1);
        reverse(array, shift, array.length - 1);
        reverse(array, 0, array.length - 1);
    }

    /**
     * Reverses array in place
     *
     * @param array source
     * @param start index inclusive
     * @param end   index inclusive
     */
    public static void reverse(int[] array, int start, int end) {
        if (array == null || start > array.length || end > array.length || start > end) {
            throw new IllegalArgumentException("Invalid args");
        }
        int len = end - start + 1;
        for (int i = start; i < start + len / 2; i++) {
            int tmp = array[i];
            array[i] = array[start + end - i];
            array[start + end - i] = tmp;
        }
    }

    @Test
    public void testReverse() {
        int[] arr = {-2, 1, 0, 4, 5};
        reverse(arr, 0, arr.length - 1);
        assertArrayEquals(new int[]{5, 4, 0, 1, -2}, arr);

        arr = new int[]{1};
        reverse(arr, 0, 0);
        assertArrayEquals(new int[]{1}, arr);

        arr = new int[]{-2, 1, 0, 4, 5, 8};
        reverse(arr, 3, arr.length - 1);
        assertArrayEquals(new int[]{-2, 1, 0, 8, 5, 4}, arr);

        arr = new int[]{-2, 1, 0, 4, 5, 8};
        reverse(arr, 1, 4);
        assertArrayEquals(new int[]{-2, 5, 4, 0, 1, 8}, arr);
    }

    @Test
    public void test1() {
        int[] arr = {-2, 1, 0, 4, 5};
        rotateLeft1(arr, 2);
        assertArrayEquals(new int[]{0, 4, 5, -2, 1}, arr);
    }

    @Test
    public void test2() {
        int[] arr = {-2, 1, 0, 4, 5};
        rotateLeft2(arr, 2);
        assertArrayEquals(new int[]{0, 4, 5, -2, 1}, arr);
    }

}
