package com.id.math.array;

import com.id.math.util.ArrayUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;

public class ShuffleArray {

    /**
     * Shuffle array randomly in-place.
     * Time complexity: O(n)
     * Space: O(1)
     */
    public static void shuffle(int[] array) {
        Random random = new Random();
        for (int i = array.length; i > 0; i--) {
            int newI = random.nextInt(i);
            ArrayUtils.swap(array, i - 1, newI);
        }
    }

    @Test
    public void test() {
        int[] arr = {9, -2, 1, 0, 4, 5};
        int copy[] = Arrays.copyOf(arr, arr.length);
        ArrayUtils.printArray(arr);
        shuffle(copy);
        ArrayUtils.printArray(copy);

        Arrays.sort(arr);
        Arrays.sort(copy);
        assertArrayEquals(arr, copy);
        ArrayUtils.printArray(copy);
    }

    /**
     * Shuffle M elements from array randomly of size N.
     */
    public static int[] shuffleM(int[] original, int m) {
        if (original == null || m <= 0 || m > original.length) {
            throw new IllegalArgumentException("invalid input");
        }
        Random random = new Random();
        int[] subset = new int[m];
        //fill in subset array with first part of original array.
        for (int i = 0; i < m; i++) {
            subset[i] = original[i];
        }
        for (int i = m; i < original.length; i++) {
            int k = random.nextInt(i + 1);
            if (k < m) {
                subset[k] = original[i];
            }
        }
        return subset;
    }


    @Test
    public void testShuffleM() {
        int[] arr = {9, -2, 1, 0, 4, 5, 2, -9, 8};
        ArrayUtils.printArray(arr);
        int[] subArr = shuffleM(arr, 4);
        ArrayUtils.printArray(subArr);
    }

}
