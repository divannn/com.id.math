package com.id.math.array;

import org.junit.Test;

import java.util.function.Predicate;

import static org.junit.Assert.assertEquals;

public class RemoveArbitraryItems {

    /**
     * Removes items from array in-place. Keeps order.
     *
     * @param arr    source array
     * @param remove true if item should be deleted
     * @return new size of array
     */
    public static int removeItems(int[] arr, Predicate<Integer> remove) {
        if (arr == null) {
            throw new IllegalArgumentException("invalid argument");
        }
        int last = -1;//index of last valid item(that should remain in array)
        for (int i = 0; i < arr.length; i++) {
            if (!remove.test(arr[i])) {//valid item  - move it forward to beginning part of array.
                last++;
                if (last < i) {// skip if item already placed properly
                    arr[last] = arr[i];
                    System.err.println("moved " + arr[i] + " to " + last);
                }
            }
        }
        return last == -1 ? 0 : last + 1;
    }

    /**
     * Removes items from array in-place. Keeps order.
     *
     * @param arr    source array
     * @param remove true if item should be deleted
     * @return new size of array
     */
    public static int removeItemsUnordered(int[] arr, Predicate<Integer> remove) {
        if (arr == null) {
            throw new IllegalArgumentException("invalid argument");
        }
        int length = arr.length;
        for (int i = length - 1; i >= 0; i--) {
            if (remove.test(arr[i])) {
                arr[i] = arr[--length];
            }
        }
        return length;
    }

    @Test
    public void test1() {
        int[] arr = {};
        int new_length = removeItems(arr, it -> it == 3);
        assertEquals(0, new_length);

        arr = new int[]{54};
        new_length = removeItems(arr, it -> it == 54);
        assertEquals(0, new_length);

        arr = new int[]{2, 4, 6, 1, 3, 8};
        new_length = removeItems(arr, it -> it % 2 == 0);
        assertEquals(2, new_length);
        assertEquals(arr[0], 1);
        assertEquals(arr[1], 3);

        arr = new int[]{1, 2, 3, 2, 4, 6, 8, 4, 2};
        new_length = removeItems(arr, it -> it == 2);
        assertEquals(6, new_length);
        assertEquals(arr[0], 1);
        assertEquals(arr[5], 4);
    }

    @Test
    public void test2() {
        int[] arr = {};
        int new_length = removeItemsUnordered(arr, it -> it == 3);
        assertEquals(0, new_length);

        arr = new int[]{54};
        new_length = removeItemsUnordered(arr, it -> it == 54);
        assertEquals(0, new_length);

        arr = new int[]{2, 4, 6, 1, 3, 8};
        new_length = removeItemsUnordered(arr, it -> it % 2 == 0);
        assertEquals(2, new_length);

        arr = new int[]{1, 2, 3, 2, 4, 6, 8, 4, 2};
        new_length = removeItemsUnordered(arr, it -> it == 2);
        assertEquals(6, new_length);
    }

}
