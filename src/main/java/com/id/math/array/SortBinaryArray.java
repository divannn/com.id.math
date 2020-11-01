package com.id.math.array;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

/**
 * Sort array containing only 1s and 0s
 */
public class SortBinaryArray {

    /**
     * Sum all items.
     *
     * @param arr source
     * @time O(n)
     * @space O(1)
     */
    public void sort1(int [] arr) {
        int N = arr.length;
        int sum = 0;
        int i;
        for (i = 0; i < N; i++)
            sum += arr[i];
        for (i = 0; i < N - sum; i++)
            arr[i] = 0;
        for (i = N - sum; i < N; i++)
            arr[i] = 1;
    }

    /**
     * Count 0s.
     *
     * @param arr source
     * @time O(n)
     * @space O(1)
     */
    public void sort2(int [] arr) {
        int count = 0;
        int N = arr.length;
        for (int j : arr) {
            if (j == 0)
                count++;
        }
        for (int i = 0; i < count; i++)
            arr[i] = 0;
        for (int i = count; i < N; i++)
            arr[i] = 1;
    }

    /**
     * 1 pass
     *
     * @param arr source
     * @time O(n)
     * @space O(1)
     */
    public void sort3(int [] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            /* Increment left index while we see 0 at left */
            while (arr[left] == 0 && left < right)
                left++;

            /* Decrement right index while we see 1 at right */
            while (arr[right] == 1 && left < right)
                right--;

            /* If left is smaller than right then there is a 1 at left
               and a 0 at right.  Swap them*/
            if (left < right) {
                arr[left] = 0;
                arr[right] = 1;
                left++;
                right--;
            }
        }
    }

    @Test
    public void test1() {
        int [] arr = new int[]{0, 1, 0, 1, 1, 1, 0, 0, 1};
        int [] copy = Arrays.copyOf(arr, arr.length);
        sort1(arr);
        Arrays.sort(copy);
        assertArrayEquals(copy, arr);
        System.err.println("sorted: " + Arrays.toString(arr));
    }

    @Test
    public void test2() {
        int [] arr = new int[]{0, 1, 0, 1, 1, 1, 0, 0, 1};
        int [] copy = Arrays.copyOf(arr, arr.length);
        sort2(arr);
        Arrays.sort(copy);
        assertArrayEquals(copy, arr);
        System.err.println("sorted: " + Arrays.toString(arr));
    }

    @Test
    public void test3() {
        int [] arr = new int[]{0, 1, 0, 1, 1, 1, 0, 0, 1};
        int [] copy = Arrays.copyOf(arr, arr.length);
        sort3(arr);
        Arrays.sort(copy);
        assertArrayEquals(copy, arr);
        System.err.println("sorted: " + Arrays.toString(arr));
    }
}
