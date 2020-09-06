package com.id.math.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

//leetcode
//https://leetcode.com/problems/remove-duplicates-from-sorted-array
public class RemoveDuplicates {

    /**
     * Removes duplicate items from sorted array in-place so that each element appear only once. Keeps order.
     *
     * @time O(n)
     * @param arr source sorted array
     * @return new size of array
     */
    public int removeDuplicates(int[] arr) {
        if (arr == null) {
            return 0;
        }
        if (arr.length < 2) {
            return arr.length;
        }

        int last = 0;//index of last valid item(that should remain in array)
        for (int i = 1; i < arr.length; i++) {
            if (arr[last] != arr[i]) {
                arr[++last] = arr[i];
            }
        }
        return last + 1;
    }

    @Test
    public void test0() {
        int[] arr = {};
        int new_length = removeDuplicates(arr);
        assertEquals(0, new_length);

        arr = new int[]{54};
        new_length = removeDuplicates(arr);
        assertEquals(1, new_length);

        arr = new int[]{5, 5, 5};
        new_length = removeDuplicates(arr);
        assertEquals(1, new_length);
    }


    @Test
    public void test1() {
        int[] arr = {2, 5, 8, 8, 8, 9, 9, 10, 11};
        int new_length = removeDuplicates(arr);
        assertEquals(6, new_length);
        assertEquals(arr[0], 2);
        assertEquals(arr[1], 5);
        assertEquals(arr[2], 8);
    }

    @Test
    public void test2() {
        int[] arr = {0, 0, 1, 2, 2, 3, 4, 4, 5, 6, 6};
        int new_length = removeDuplicates(arr);
        assertEquals(7, new_length);
        assertEquals(arr[0], 0);
        assertEquals(arr[6], 6);
    }

}
