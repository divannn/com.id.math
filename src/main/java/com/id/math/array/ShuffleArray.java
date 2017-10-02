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
    public void test0() {
        int[] data1 = {9, -2, 1, 0, 4, 5};
        int[] data2 = {9, -2, 1, 0, 4, 5};
        ArrayUtils.printArray(data1);
        shuffle(data2);
        ArrayUtils.printArray(data2);

        Arrays.sort(data1);
        Arrays.sort(data2);
        assertArrayEquals(data1, data2);
        ArrayUtils.printArray(data2);
    }

}
