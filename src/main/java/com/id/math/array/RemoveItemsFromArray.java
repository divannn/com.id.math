package com.id.math.array;

import org.junit.Test;

import java.util.function.Predicate;

import static org.junit.Assert.assertEquals;

public class RemoveItemsFromArray {

    /**
     * Removes items from array in-place. Keeps order.
     * After removal filtered items are in the end of array.
     *
     * @param arr    source array
     * @param remove true if item should be deleted
     * @return new size of array
     */
    public static int removeItems(int[] arr, Predicate<Integer> remove) {
        if (arr == null) {
            throw new IllegalArgumentException("null array");
        }
        int last = -1;//index of last valid (that should remain in array)
        for (int i = 0; i < arr.length; i++) {
            if (!remove.test(arr[i])) {//valid item  - move it forward to beginning part of array.
                last++;
                if (last < i) {// skip if item already placed properly
                    arr[last] = arr[i];
                    System.err.println("moved < " + arr[i] + " to " + last);
                }
            }
        }
        return last == -1 ? 0 : last + 1;
    }

    @Test
    public void test0() {
        int[] arr = {};
        int new_length = removeItems(arr, it -> it == 3);
        assertEquals(0, new_length);

        arr = new int[]{54};
        new_length = removeItems(arr, it -> it == 54);
        assertEquals(0, new_length);
    }


    @Test
    public void test1() {
        int[] arr = {2, 4, 6, 1, 3, 8};
        int new_length = removeItems(arr, it -> it % 2 == 0);
        assertEquals(2, new_length);
        assertEquals(arr[0], 1);
        assertEquals(arr[1], 3);
    }

    @Test
    public void test2() {
        int[] arr = {1, 2, 3, 2, 4, 6, 8, 4, 2};
        int new_length = removeItems(arr, it -> it == 2);
        assertEquals(6, new_length);
        assertEquals(arr[0], 1);
        assertEquals(arr[5], 4);
    }

}
