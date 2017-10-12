package com.id.math.array;

import com.id.math.util.ArrayUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;

/**
 * Shuffle array randomly in-place.
 */
public class ShuffleArray {

    /**
     * Time complexity: O(n)
     * Space: O(1)
     */
    public static void shuffle(int[] array) {
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int newI = random.nextInt(i);
            ArrayUtils.swap(array, i, newI);
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

}
